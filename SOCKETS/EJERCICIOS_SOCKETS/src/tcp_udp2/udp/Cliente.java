package tcp_udp2.udp;
import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        InetAddress inet = InetAddress.getLocalHost();
        //socket del cliente
        DatagramSocket socket = new DatagramSocket(34567); //Puerto local
        int puerto =5555; // servidor
        byte[] numeros = new byte[5]; //Array almacenar mensaje

        int random= (int) ((Math.random()*10)+1);

        for (int i =0;i<5;i++){
            System.out.println("numero añadido " + random );
            numeros[i]= (byte) random;
            random= (int) ((Math.random()*10)+1);
        }
        DatagramPacket envio = new DatagramPacket (numeros,numeros.length , inet, puerto);//array,tamaño del array,inet, puerto servidor

        //enviar el packet
        socket.send(envio);
        socket.close();
    }
}
