package ejercicio1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {
        Scanner teclado= new Scanner(System.in);
        String host = "localhost"; // Cambia esto a la IP del servidor
        int puerto = 5555; // Puerto en el que el servidor está escuchando
        System.out.println("ingresa un numero");
        int num= teclado.nextInt();
        try {

            // Crear socket y conectarse al servidor
            Socket cliente = new Socket(host, puerto);

            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

            salida.writeInt( num);
            salida.close();
            cliente.close();

            //-----------------------ahora recibir el factorial del servidor
        } catch (Exception e) {


        }
    }
}





