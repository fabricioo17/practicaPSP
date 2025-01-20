public class Caja extends Thread {
    int identificador;
    boolean libre=true;

    Proceso proceso;

    public Caja(int identificador, Proceso proceso){
        this.identificador=identificador;
        this.proceso=proceso;
    }

    @Override
    public void run() {
        try {
            proceso.cambiarLibre(libre,identificador);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
