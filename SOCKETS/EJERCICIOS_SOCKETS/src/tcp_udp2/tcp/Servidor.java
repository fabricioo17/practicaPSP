package tcp_udp2.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket= new ServerSocket(5555);
        Socket socket=serverSocket.accept();
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        int mensaje = entrada.readInt();
        System.out.println("el mensaje es " + mensaje);
        entrada.close();
        while (true){
            socket=serverSocket.accept();
            entrada=new DataInputStream(socket.getInputStream());
            mensaje=entrada.readInt();
            System.out.println("el mensaje es " + mensaje);
            entrada.close();
        }

    }
}
