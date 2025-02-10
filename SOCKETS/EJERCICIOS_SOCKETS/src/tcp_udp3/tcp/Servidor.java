package tcp_udp3.tcp;

import tcp_udp3.Factura;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        ServerSocket server = new ServerSocket(5555);

        Socket socket =server.accept();

        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        Factura factura = (Factura) entrada.readObject();
        String nombre = factura.getNombre() ;
        System.out.println("nombre de la factura es " + nombre);
    }
}
