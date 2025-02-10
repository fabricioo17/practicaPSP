package tcp_udp3.tcp;

import tcp_udp3.Factura;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Factura factura = new Factura(teclado);

        Socket socket= new Socket("localhost",5555);
        ObjectOutputStream salida= new ObjectOutputStream(socket.getOutputStream());

        salida.writeObject(factura);


    }
}
