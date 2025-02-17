package tcp_udp3.udp;

import tcp_udp3.Factura;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        Factura factura = new Factura(teclado);
        //-------crear la salida
        ByteArrayOutputStream enviar = new ByteArrayOutputStream();
        ObjectOutputStream escribir = new ObjectOutputStream(enviar);
        escribir.writeObject(factura);
        escribir.flush();

        byte[] data = enviar.toByteArray();

        InetAddress inetAddress =   InetAddress.getLocalHost();
        DatagramSocket socket=new DatagramSocket(1234);

        DatagramPacket packet=new DatagramPacket(data, data.length,inetAddress,5555);
        socket.send(packet);
//--------------------------------------------------------------------------
        //recibir
    byte[] data2=new byte[data.length];


        DatagramPacket packetRecibido = new DatagramPacket(data2,data2.length);
        //---------recibimos y guardamos en el packeterecibido
        socket.receive(packetRecibido);


        ByteArrayInputStream recibir = new ByteArrayInputStream(data2,0, data.length);

        //Deserealizar
        ObjectInputStream objetoRecibido = new ObjectInputStream(recibir);

        Factura facturaRecibida = (Factura)(objetoRecibido.readObject());

        System.out.println( facturaRecibida.toString());
    }
}
