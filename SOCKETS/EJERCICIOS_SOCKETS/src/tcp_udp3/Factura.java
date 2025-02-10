package tcp_udp3;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Factura implements Serializable {
    private String nombre;
    private String fecha;

    public String getNombre() {
        return nombre;
    }

    private int  importe;
    private String tipo;
    private  int iva;
    private  int total;

    public Factura(Scanner teclado) {
        System.out.println("ingresa el nombre");
        nombre=teclado.next();

        System.out.println("ingresa la fecha");
        teclado.next();

        System.out.println("ingresa el importe");
        importe=teclado.nextInt();

        System.out.println("elige el tipo de iva");

        System.out.println("ingresa el IVA");
        teclado.nextInt();


    }
}
