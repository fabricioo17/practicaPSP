
package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {

        int puerto = 5555;
        ServerSocket servidor= new ServerSocket(puerto);
        ServerSocket servidor2= new ServerSocket(5000);
        Socket socket=servidor.accept();
        Socket socket2=servidor2.accept();
//-------------recbir numero del cliente 1
        DataInputStream entrada= new DataInputStream(socket.getInputStream());

        int recibido= entrada.readInt();
        entrada.close();
        socket.close();


//-----------------enviar a cliente 2 el numero

        DataOutputStream salida=new DataOutputStream(socket2.getOutputStream());

        salida.writeInt(recibido);

        //-------------------------

    }

}
