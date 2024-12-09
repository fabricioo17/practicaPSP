package ProdCons2;

//Clase Productor: produce números y los pone en la cola usando método "put"
public class Productor extends Thread {
    private Cola cola;
    private int n;

    //Constructor recibe la cola y un id para el hilo prodcutor
    public Productor(Cola c, int n) {
        cola = c;
        this.n = n;
    }


    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "=>Productor : " + n);
            try {
                cola.put((int)(Math.random()*10)+1); //escribe el número en la coala

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


