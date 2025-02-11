package tcp_udp3;

import java.io.Serializable;
import java.util.Scanner;

public class Factura implements Serializable {
    private String numero;
    private String fecha;

    public String getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public int getTipo() {
        return tipo;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }

    private double  importe;
    private int tipo;
    private  double iva;
    private  double total;

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numero='" + numero + '\'' +
                ", fecha='" + fecha + '\'' +
                ", importe=" + importe +
                ", tipo=" + tipo +
                ", iva=" + iva +
                ", total=" + total +
                '}';
    }

    public Factura(Scanner teclado) {
        System.out.println("ingresa el numero de factura");
        numero =teclado.next();

        System.out.println("ingresa la fecha");
        fecha =teclado.next();

        System.out.println("ingresa el importe");
        importe=teclado.nextDouble();

        System.out.println("elige el tipo de iva, 1 IGC, 2 ESP , 3  EUR");
        int opcion = teclado.nextInt();
        if (opcion==1){
        tipo=1;
        }
        else if (opcion==2) {
        tipo=2;
        }
        else {
            tipo=3;
        }
        }
}
