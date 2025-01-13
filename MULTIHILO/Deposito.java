
public class Deposito extends Thread {
    private boolean consumir1 = true;
    private boolean consumir2 = true;
    private boolean consumir3 = true;
    private double litrosdeposito = 0;

    public Deposito() {
        // Constructor vacío
    }

    // Método para que un camión consuma el depósito
    public synchronized double get(int identificador) throws InterruptedException {
        // Espera mientras el depósito esté vacío o el camión no pueda consumir
        while ((litrosdeposito == 0) ||
                (identificador == 1 && !consumir1) ||
                (identificador == 2 && !consumir2) ||
                (identificador == 3 && !consumir3)) {
            System.out.println("El camión " + identificador + " está esperando");
            wait();
        }

        // Camión consume el contenido del depósito
        double litrosConsumidos = litrosdeposito;
        litrosdeposito = 0; // Vaciar el depósito después del consumo

        // Actualiza el estado del camión que consumió
        if (identificador == 1) {
            consumir1 = false; // Este camión ya consumió, debe esperar al próximo llenado
            consumir2 = true;  // El siguiente camión está listo para consumir
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
        notifyAll(); // Notifica al productor y otros camiones
        return litrosConsumidos;
    }

    // Método para que el productor llene el depósito
    public synchronized void put(double litros) throws InterruptedException {
        // Espera mientras el depósito no esté vacío
        while (litrosdeposito > 0) {
            System.out.println("Depósito lleno, esperando a que un camión consuma");
            wait();
        }

        // Llena el depósito con la nueva cantidad de litros
        litrosdeposito = litros;

        System.out.println("El productor produjo " + litros + " litros");
        notifyAll(); // Notifica a los camiones que ya pueden consumir
    }
}
