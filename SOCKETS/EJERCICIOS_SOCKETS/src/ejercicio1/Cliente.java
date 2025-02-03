import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EJERCICIO1 {

    public static void main(String[] args) throws IOException {
        Scanner teclado= new Scanner(System.in);
        String host = "192.168.1.10"; // Cambia esto a la IP del servidor
        int puerto = 5555; // Puerto en el que el servidor está escuchando
        System.out.println("ingresa un numero");
        teclado.nextInt();
        try {

            // Crear socket y conectarse al servidor
            Socket cliente = new Socket(host, puerto);

            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

            salida.writeUTF("");
        } catch (Exception e) {


        }
    }
}
