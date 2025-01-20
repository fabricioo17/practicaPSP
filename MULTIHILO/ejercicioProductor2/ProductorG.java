public class ProductorG extends  Thread{

    private Deposito deposito;

    public ProductorG (Deposito deposito){
        this.deposito=deposito;
    }


    public void run()
    {

        for (int i =0;i<15;i++) {

            try {
                deposito.put();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1); // Simula el tiempo de producción
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
