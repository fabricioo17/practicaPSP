import java.util.Random;

public class ProductorG extends  Thread{

    private Deposito deposito;

    public ProductorG (Deposito deposito){
        this.deposito=deposito;
    }


    public void run()
    {
        Random random=  new Random();
        for (int i =0;i<15;i++) {
            int litrosdeposito = random.nextInt(10) + 1;
            try {
                deposito.put(litrosdeposito);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(10000); // Simula el tiempo de producción
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
