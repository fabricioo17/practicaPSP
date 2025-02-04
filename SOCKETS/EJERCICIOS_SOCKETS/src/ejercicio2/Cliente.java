package ejercicio2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner teclado= new Scanner(System.in);
        InetAddress inet = InetAddress.getLocalHost();
        int puerto =5555; // servidor
        byte[] numero = new byte[1024]; //Array almacenar mensaje

        System.out.println("ingresa el numero ");
       String num= teclado.next();
        numero=num.getBytes(); //llenamos el array
        //Construcción del DatagramaPacket
        DatagramPacket envio = new DatagramPacket (numero,numero.length , inet, puerto);//array,tamaño del array,inet, puerto servidor

        //socket del cliente
        DatagramSocket socket = new DatagramSocket(34567); //Puerto local

        //enviar el packet
        socket.send(envio);
        socket.close();

    }
}
