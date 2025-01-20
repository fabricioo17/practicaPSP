public class Proceso {

    Boolean cajaDisponible =true;


    public synchronized void pagar (int identificador) throws InterruptedException {

            while (cajaDisponible == false){

                System.out.println("el cliente " + identificador+  " tiene que esperar, no hay caja disponible");

            wait();
        }
        System.out.println("el cliente "  + identificador + " esta pagando");
        cajaDisponible =false;
        notifyAll();
    }

    public synchronized boolean cambiarLibre( int identificador) throws InterruptedException {

        while (cajaDisponible ==false){
            System.out.println("la caja " + identificador + " esta ocupado");
            wait();
        }
        System.out.println("la caja " + identificador + " libre");
        Thread.sleep(5000);
        cajaDisponible=true;
        notifyAll();
       return cajaDisponible;
    }


}
