package tcp_ejercicio4;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente extends Thread {
private int id;
private Socket socket=new Socket("localhost",5555);
juego_hilo juego=new juego_hilo();

public Cliente(int id) throws IOException {
    socket=new Socket("localhost",5555);
    this.id=id;
}

public void run() {

    while (true){

        try {
            System.out.println("el identificador es " + id);
            juego.enviar(socket,5,id);

            Thread.sleep(1000); // Esperar 1 segundo antes de enviar otro número

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }



    }

}


}
