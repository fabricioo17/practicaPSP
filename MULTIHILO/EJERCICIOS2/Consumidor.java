package ProdCons2;

//Clase consumidor: recoge número de la cola con método "get"
public class Consumidor extends Thread {
    private int sumaTotal;
    private Cola cola;
    private int n;

    //Constructor recibe la cola y un id para el hilo consumidor
    public Consumidor(Cola c, int n) {
        cola = c;
        this.n = n;
    }

    public void run() {
        int valor = 0;
        for (int i = 0; i < 10; i++) {
            valor = cola.get(i); //recoge el n�mero
            System.out.println(i + "=>Consumidor: " + n
                               + ", consume: " + valor);
            sumaTotal=sumaTotal+valor;
        }
        System.out.println("suma total: " + sumaTotal);
    }
}
