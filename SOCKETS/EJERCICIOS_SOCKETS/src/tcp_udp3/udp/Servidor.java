package tcp_udp3.udp;

import tcp_udp3.Factura;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DatagramSocket socket = new DatagramSocket(5555);
        byte[] data = new byte[1024];  // recibir datos


        DatagramPacket packet = new DatagramPacket(data, data.length);

        // recibir el paquete
        socket.receive(packet);

        //  leer los datos recibidos
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data, 0, data.length);


        //  deserializar el objeto
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);


        Factura recibido = (Factura) objectInputStream.readObject();


        System.out.println("Factura recibida: " + recibido.getNumero());


        objectInputStream.close();

        
        socket.close();
    }
}

