public class Proceso {

    Boolean cajaDisponible =true;


    public synchronized void pagar (int identificador) throws InterruptedException {

            while (cajaDisponible == false){

                System.out.println("el cliente " + identificador+  " tiene que esperar, no hay caja disponible");

            wait();
        }
        System.out.println("el cliente "  + identificador + " esta pagando");
        Thread.sleep(5000);

        System.out.println("cliente  " + identificador + " termino");
        cajaDisponible =true;
        notifyAll();
    }

    public synchronized boolean cambiarLibre(Boolean libre, int identificador) throws InterruptedException {

        while (cajaDisponible ==true){
            System.out.println("la caja " + identificador + " esta libre");
            wait();
        }
        cajaDisponible=false;
        notifyAll();
       return cajaDisponible;
    }


}
