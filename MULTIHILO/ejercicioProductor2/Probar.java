public class Probar {


    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        Camion camion1=new Camion(deposito,1);

        Camion camion2=new Camion(deposito,2);

        Camion camion3=new Camion(deposito,3);

        ProductorG productorG=new ProductorG(deposito);

        productorG.start();
        camion1.start();
        camion2.start();
        camion3.start();
    }
}
