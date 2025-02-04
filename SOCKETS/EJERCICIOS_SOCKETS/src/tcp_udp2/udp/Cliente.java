package tcp_udp2.udp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket= new ServerSocket(5555);
        Socket socket=serverSocket.accept();
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String mensaje = entrada.readUTF();
        System.out.println("el mensaje es " + mensaje);
        entrada.close();
        while (true){
            socket=serverSocket.accept();
            entrada=new DataInputStream(socket.getInputStream());
            mensaje=entrada.readUTF();
            System.out.println("el mensaje es " + mensaje);
            entrada.close();
        }

    }
}
