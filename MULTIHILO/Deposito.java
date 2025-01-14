import java.util.Random;

public class Deposito extends Thread {
    private boolean consumir1 = true;
    private boolean consumir2 = true;
    private boolean consumir3 = true;
    private double litrosdeposito = 0;

    public Deposito() {
        // Constructor vacío
    }

    
    public synchronized double get(int identificador) throws InterruptedException {
        while ((litrosdeposito == 0) ||
                (identificador == 1 && !consumir1) ||
                (identificador == 2 && !consumir2) ||
                (identificador == 3 && !consumir3)) {
            System.out.println("El camión " + identificador + " está esperando");
            wait();
        }

       
        double litrosConsumidos = litrosdeposito;
        litrosdeposito = 0; // Vaciar el depósito 

        // Actualiza el estado del camión que consumió
        if (identificador == 1) {
            consumir1 = false; // Este camión ya consumió
            consumir2 = true;  // El siguiente listo para consumir
            consumir3 = true;
        } else if (identificador == 2) {
            consumir2 = false;
            consumir1 = true;
            consumir3 = true;
        } else if (identificador == 3) {
            consumir3 = false;
            consumir1 = true;
            consumir2 = true;
        }

        System.out.println("El camión " + identificador + " consumió " + litrosConsumidos + " litros");
        notifyAll(); 
        return litrosConsumidos;
    }

   
    public synchronized void put() throws InterruptedException {
        Random random=  new Random();
        int litros = random.nextInt(10) + 1;
      
        while (litrosdeposito > 0) {
            System.out.println("Depósito lleno, esperando a que un camión consuma");
            wait();
        }

      
        litrosdeposito = litros;

        System.out.println("El productor produjo " + litros + " litros");
        notifyAll(); // Notifica a los camiones que ya pueden consumir
    }
}

