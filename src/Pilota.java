import java.util.ArrayList;

public class Pilota extends Thread {
    public static int tempoPista = 1500;
    private String nome;
    private Spogliatoio spogliatoio;
    private long tempo;

    public static ArrayList<Pilota> classifica = new ArrayList<>();

    public Pilota(String s, Spogliatoio sp) {
        nome = s;
        spogliatoio = sp;
    }

    public void run() {
        spogliatoio.usa(this);

        // fai gara
        long inizio = System.nanoTime();
        try { Thread.sleep((long)(Math.random() * 1000)); } 
        catch (InterruptedException e) { e.printStackTrace(); }
        long fine = System.nanoTime();

        spogliatoio.usa(this);

        tempo = (fine - inizio)/1000000;

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
