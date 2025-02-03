

package ejercicio1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente2 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",5000);

        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        int valor=entrada.readInt();
        System.out.println(factorial(valor));
    }


    public static int factorial(int valor){
        int num=1;
        for (int i=1;i<=valor;i++ ){
            num=num*i;
        }

        return num;
    }
}






