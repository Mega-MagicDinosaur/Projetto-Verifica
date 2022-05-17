public class Semaforo {
    private int valore;

    public Semaforo(int _v) {
        valore = _v;
    }

    public synchronized void occupa() {
        while(valore == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } valore--;

    }

    public synchronized void libera() {
        valore++;
        notify();
    }
}
