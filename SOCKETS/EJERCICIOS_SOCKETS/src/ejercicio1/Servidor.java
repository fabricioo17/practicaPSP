
package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
//-------------recbir numero del cliente 1
        ServerSocket servidor= new ServerSocket(5555);
        Socket socket=servidor.accept();

        DataInputStream entrada= new DataInputStream(socket.getInputStream());

        int recibido= entrada.readInt();
        entrada.close();
        socket.close();
        servidor.close();

//-----------------enviar a cliente 2 el numero
        ServerSocket servidor2= new ServerSocket(5000);
        Socket socket2=servidor2.accept();
        DataOutputStream salida=new DataOutputStream(socket2.getOutputStream());

        salida.writeInt(recibido);

        //------------RECIBIR DEL CLIENTE 2 -------------


        DataInputStream entrada2= new DataInputStream(socket2.getInputStream());
        int factorial= entrada2.readInt();
        System.out.println("el factorial es " + factorial);
    salida.close();
    socket2.close();
    entrada2.close();
    servidor2.close();
    }

}
