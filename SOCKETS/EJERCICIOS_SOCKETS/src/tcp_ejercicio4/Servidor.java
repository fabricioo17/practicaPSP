package tcp_ejercicio4;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        byte[] recibido ;
        int numRandom = (int) (Math.random() * 10) + 1;
        //------------crear el servidor ---------------
        ServerSocket servidor = new ServerSocket(5555);
        Socket  socket1= servidor.accept();
        DataInputStream entrada ;


while (true){
    entrada = new DataInputStream(socket1.getInputStream());
    recibido = entrada.readAllBytes();
    if (recibido[1]==numRandom){
        break;
    }
    System.out.println("numero recibido " + recibido[1] + " por el cliente " + recibido[0]);

    socket1=servidor.accept();
}


    }
}
