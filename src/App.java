public class App {
    public static void main(String[] args) throws Exception {
        Semaforo semaforo = new Semaforo(2);
        Spogliatoio spogliatoio = new Spogliatoio(semaforo);

        Pilota p1 = new Pilota("Uno", spogliatoio);
        Pilota p2 = new Pilota("Due", spogliatoio);
        Pilota p3 = new Pilota("Tre", spogliatoio);
        Pilota p4 = new Pilota("Quattro", spogliatoio);
        Pilota p5 = new Pilota("Cinque", spogliatoio);
        Pilota p6 = new Pilota("Sei", spogliatoio);
        Pilota p7 = new Pilota("Sette", spogliatoio);
        Pilota p8 = new Pilota("Otto", spogliatoio);

        System.out.println("=====  INIZIO  =====");

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
        
        
        // print classifica
        System.out.println("\n");
        System.out.println("===== CLASSIFICA =====");
        for (Pilota p : Pilota.classifica) {
            System.out.println(p.getNome());
        }

        System.out.println("=====  FINE  =====");
    }
}
