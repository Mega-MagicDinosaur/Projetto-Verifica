public class Spogliatoio {
    private Semaforo semaforo;

    public Spogliatoio(Semaforo _s) {
        semaforo = _s;
    }

    public void usa(Pilota p) {
        semaforo.occupa();
        System.out.println("-SPOGLIATOIO: lo spogliatoio è usato da " + p.getNome());

        try { Thread.sleep((long)(Math.random() * 1000)); }
        catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("-SPOGLIATOIO: " + p.getNome() +  " è uscito dallo spogliatoio");
        semaforo.libera();
    }
}
