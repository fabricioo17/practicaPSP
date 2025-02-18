public class Main {
    public static void main(String[] args) {
        Gimnasio gimnasio =new Gimnasio();
        Cliente cliente1=new Cliente(1, gimnasio);

        Cliente cliente2=new Cliente(2, gimnasio);

        Cliente cliente3=new Cliente(3, gimnasio);

        Cliente cliente4=new Cliente(4, gimnasio);

        Cliente cliente5=new Cliente(5, gimnasio);
        Cliente cliente6=new Cliente(6, gimnasio);
        Cliente cliente7=new Cliente(7, gimnasio);
        Cliente cliente8=new Cliente(8, gimnasio);
        Cliente cliente9=new Cliente(9, gimnasio);

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        cliente8.start();
        cliente9.start();
    }
}
