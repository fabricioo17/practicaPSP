package tcp_udp3.tcp;

import tcp_udp3.Factura;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        ServerSocket server = new ServerSocket(5555);

        Socket socket =server.accept();

        //CREAMOS UN FLUJO DE ENTRADA CON EL SOCKET
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        //LEEMOS Y LOS CASTEAMOS A FACTURA
        Factura factura = (Factura) entrada.readObject();
        String nombre = factura.getNumero() ;
        System.out.println("nuemro de la factura es " + nombre);



        //-----------CALCULAR----------------------------
        double iva = (0.07)*(factura.getImporte());
        double total= factura.getImporte() + iva   ;
        factura.setIva(iva);
        factura.setTotal(total);


        //---------ENVIAR-----------

        ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
        salida.writeObject(factura);
    }
}
