

package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente2 {
    public static void main(String[] args) throws IOException {
        Socket cliente=new Socket("localhost",5000);

        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        int valor=entrada.readInt();

        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
        salida.writeInt(factorial(valor));
        salida.close();
        cliente.close();
    }


    public static int factorial(int valor){
        int num=1;
        for (int i=1;i<=valor;i++ ){
            num=num*i;
        }

        return num;
    }
}






