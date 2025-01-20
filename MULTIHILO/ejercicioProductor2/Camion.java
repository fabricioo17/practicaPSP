public class Camion extends Thread{
    private  double total=0;
private  int identificador;
    private Deposito deposito;

    public Camion(Deposito deposito, int identificador){
        this.deposito=deposito;
        this.identificador=identificador;
    }


    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
               double litros= deposito.get(identificador);

               total=total+litros;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(15000); // Simula el tiempo de consumo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("total de litros de camion " + identificador + " es " + total);
    }
}
