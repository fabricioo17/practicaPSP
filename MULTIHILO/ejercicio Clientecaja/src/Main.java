// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Proceso proceso = new Proceso();

        Cliente cliente1=new Cliente(1,proceso);
        Cliente cliente2=new Cliente(2,proceso);
        Cliente cliente3=new Cliente(3,proceso  );
        Cliente cliente4=new Cliente(4,proceso);
        Cliente cliente5=new Cliente(5,proceso);
        Cliente cliente6=new Cliente(6,proceso);
        Cliente cliente7=new Cliente(7,proceso);
        Cliente cliente8=new Cliente(8,proceso);
        Cliente cliente9=new Cliente(9,proceso);
        Cliente cliente10=new Cliente(10,proceso);
        Cliente cliente11=new Cliente(11,proceso);
        Cliente cliente12=new Cliente(12,proceso);
        Cliente cliente13=new Cliente(13,proceso);
        Cliente cliente14=new Cliente(14,proceso);
        Cliente cliente15=new Cliente(15,proceso);


        Caja caja1 =new Caja(1,proceso);
        Caja caja2 =new Caja(2,proceso);
        Caja caja3 =new Caja(3,proceso);

        caja1.start();

    }
}
