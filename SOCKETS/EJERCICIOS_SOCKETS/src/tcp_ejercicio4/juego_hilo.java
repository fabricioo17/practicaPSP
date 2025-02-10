package tcp_ejercicio4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class juego_hilo {

    public juego_hilo() {

    }

    public synchronized void enviar(Socket socket,int numero,int id) throws InterruptedException, IOException {
        byte [] enviar= new byte[2];
        enviar[0]= (byte) id;
        enviar[1]= (byte) numero;
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

        salida.write(enviar);
        salida.flush();

    }
    public synchronized void recibir(Socket socket) throws InterruptedException, IOException{

    }
}