import java.util.ArrayList;

public class Pilota extends Thread {
    public static int tempoPista = 1500;
    private String nome;
    private Spogliatoio spogliatoio;
    private Semaforo semaforoGara;
    private long tempo;

    public static ArrayList<Pilota> classifica = new ArrayList<>();

    public Pilota(String s, Spogliatoio sp, Semaforo semaforoG) {
        nome = s;
        spogliatoio = sp;
        semaforoGara = semaforoG;
    }

    public void run() {
        spogliatoio.usa(this);

        // fai gara
        semaforoGara.occupa();
        System.out.println("-GARA: " + this.nome + " ha iniziato la gara!");
        long inizio = System.nanoTime();
        try { Thread.sleep((long)(Math.random() * 1000)); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        long fine = System.nanoTime();
        semaforoGara.libera();

        tempo = (fine - inizio)/1000000;
        System.out.println("-GARA: " + this.nome + " ha finito la gara, Tempo: " + this.tempo);
        
        spogliatoio.usa(this);

        inserisciInClassifica();
    }

    public String getNome() { return nome; }
    public long getTempo()  { return tempo; }

    public void inserisciInClassifica() {
        for (int i=0; i<classifica.size(); i++) {
            if (this.getTempo() < classifica.get(i).getTempo()) { 
                classifica.add(i, this);
                return;
            }
        }
        classifica.add(this);
    }


    
}
