package tcp_udp3.udp;

import tcp_udp3.Factura;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        Factura factura = new Factura(teclado);
        ByteArrayOutputStream enviar = new ByteArrayOutputStream();
        ObjectOutputStream escribir = new ObjectOutputStream(enviar);
        escribir.writeObject(factura);
        escribir.flush();

        byte[] data = enviar.toByteArray();

        InetAddress inetAddress =   InetAddress.getLocalHost();
        DatagramSocket socket=new DatagramSocket(1234);

        DatagramPacket packet=new DatagramPacket(data, data.length,inetAddress,5555);
        socket.send(packet);

    }
}
