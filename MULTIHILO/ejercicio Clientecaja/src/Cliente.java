public class Cliente extends Thread{
    int identificador;
    Proceso proceso ;
    public  Cliente(int identificador,Proceso proceso){
    this.identificador=identificador;
this.proceso=proceso;



    }

    @Override
    public void run() {
        try {
            proceso.pagar( identificador);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
