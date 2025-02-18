public class Cliente extends Thread {
    private Gimnasio gimnasio;
    private int id;

    public Cliente(int id, Gimnasio gimnasio) {
        this.id = id;
        this.gimnasio = gimnasio;
    }


    public void start() {
        try {
            gimnasio.entrar(id);

            sleep(1000);
            gimnasio.salir(id);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
