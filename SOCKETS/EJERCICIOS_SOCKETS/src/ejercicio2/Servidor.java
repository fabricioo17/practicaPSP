package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException {
        byte[] numero = new byte[1024];
        DatagramPacket packet= new DatagramPacket(numero,numero.length);// array de bytes, tamaño

        //preparar el socket
        DatagramSocket socket= new DatagramSocket(5555); //puerto local

        socket.receive(packet); // almacenamos lo recibido en el packet

        //--------impirmir para ver el nuevo que recibimos
        String recibido =new String(packet.getData()).trim();
        System.out.println(recibido);



        //----------------------enviar---------------------------//
        InetAddress inet=InetAddress.getLocalHost();
        int puertoEnviar=1234;
        DatagramPacket packet2= new DatagramPacket(numero,numero.length,inet,puertoEnviar);
        socket.send(packet2); //enviamos el paquete



        //-----------recibir factorial

        socket.receive(packet);

        System.out.println("el factorial es " + new String(packet2.getData()).trim());

    }
}
