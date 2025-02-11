package tcp_udp3.tcp;

import tcp_udp3.Factura;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        Factura factura = new Factura(teclado);

        Socket socket= new Socket("localhost",5555);

        ObjectOutputStream salida= new ObjectOutputStream(socket.getOutputStream());


        //ESCRBIMOS EN EL FLUJO DE SALIDA EL OBJETO DE FACTURA
        salida.writeObject(factura);

        //CREAMOS UN FLUJO DE ENTRADA CON EL SOCKET
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        //LEEMOS Y LOS CASTEAMOS A FACTURA
        Factura facturaRecibida = (Factura) entrada.readObject();
        System.out.println( facturaRecibida.toString());
    }
}
