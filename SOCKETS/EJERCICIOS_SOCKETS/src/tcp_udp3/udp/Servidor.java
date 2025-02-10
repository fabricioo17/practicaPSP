package tcp_udp3.udp;

import tcp_udp3.Factura;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Crear el socket para recibir datos en el puerto 5555
        DatagramSocket socket = new DatagramSocket(5555);
        byte[] data = new byte[1024];  // Buffer para recibir datos

        // Crear el DatagramPacket para almacenar el paquete recibido
        DatagramPacket packet = new DatagramPacket(data, data.length);

        // Esperar a recibir el paquete
        socket.receive(packet);

        // Crear un ByteArrayInputStream para leer los datos recibidos
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data, 0, data.length);


        // Crear un ObjectInputStream para deserializar el objeto
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        // Leer el objeto de tipo Factura
        Factura recibido = (Factura) objectInputStream.readObject();

        // Mostrar el objeto recibido (si es necesario)
        System.out.println("Factura recibida: " + recibido.getNombre());

        // Cerrar el ObjectInputStream
        objectInputStream.close();

        // Cerrar el socket
        socket.close();
    }
}

