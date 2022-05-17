public class App {
    public static void main(String[] args) throws Exception {
        Semaforo semaforo = new Semaforo(2);
        Spogliatoio spogliatoio = new Spogliatoio(semaforo);

        Pilota p1 = new Pilota("uno", spogliatoio);
        Pilota p2 = new Pilota("due", spogliatoio);
        Pilota p3 = new Pilota("tre", spogliatoio);
        Pilota p4 = new Pilota("quattro", spogliatoio);
        Pilota p5 = new Pilota("cinque", spogliatoio);
        Pilota p6 = new Pilota("sei", spogliatoio);
        Pilota p7 = new Pilota("sette", spogliatoio);
        Pilota p8 = new Pilota("otto", spogliatoio);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        
        p1.join();
        p2.join();
        p3.join();
        p4.join();
        p5.join();
        p6.join();
        p7.join();
        p8.join();

        for (Pilota p : Pilota.classifica) {
            System.out.println(p.getNome());
        }

    }
}
