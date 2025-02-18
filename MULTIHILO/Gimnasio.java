import java.util.concurrent.ArrayBlockingQueue;

public class Gimnasio {
    private final ArrayBlockingQueue<Integer> cola = new ArrayBlockingQueue<>(5);
    private boolean lleno = false; // Controla si la cola está llena

    public Gimnasio() {

    }

    public synchronized void entrar(int id) throws InterruptedException {
        while (cola.size()==5){
            System.out.println("cliente " + id + " esta esperando");
            wait();
        }
        cola.put(id);
        System.out.println("el cliente " + id + " esta dentro ");
        notifyAll();
    }

    public synchronized void salir(int id) throws InterruptedException {
        cola.take();
        notifyAll();
        System.out.println("cliente " + id + "ha salido");
    }
}
