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
        while ((litrosdeposito == 0)                ) {
            System.out.println("El camión " + identificador + " está esperando");
            wait();
        }

       
        double litrosConsumidos = litrosdeposito;
        System.out.println("El camión " + identificador + " consumió " + litrosConsumidos + " litros");
        litrosdeposito = 0; // Vaciar el depósito       
        notifyAll(); 
        return litrosConsumidos;
    }

   
    public synchronized void put() throws InterruptedException {
    
    
     	while (litrosdeposito > 0) {
            System.out.println("Depósito lleno, esperando a que un camión consuma");
            wait();
        }
        
        Random random=  new Random();
        int litros = random.nextInt(10) + 1;
       
     
        litrosdeposito = litros;
        System.out.println("El productor produjo " + litros + " litros");
        notifyAll(); // Notifica a los camiones que ya pueden consumir
    }
}


