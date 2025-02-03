import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        String host = "192.168.1.243"; // Cambia esto a la IP del servidor
        int puerto = 7777; // Puerto en el que el servidor está escuchando

        try {
            // Crear socket y conectarse al servidor
            Socket cliente = new Socket(host, puerto);

            // Enviar datos al servidor usando DataOutputStream
            DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
            String mensaje = "FABRICIO Y SERGIO IP: 192.168.114.107";
            salida.writeUTF(mensaje); // Escribir el mensaje en formato UTF-8
            System.out.println("Mensaje enviado al servidor: " + mensaje);

            // Cerrar conexión
            salida.close();
            cliente.close();
            System.out.println("Conexión cerrada");

        } catch (IOException excepcion) {
            System.out.println("Error: " + excepcion.getMessage());
        }
    }
}

