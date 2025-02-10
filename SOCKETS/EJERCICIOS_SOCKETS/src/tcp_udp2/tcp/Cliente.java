package tcp_udp2.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",5555);
        DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
        int random= (int) ((Math.random()*10)+1);
        byte[] numeros = new  byte[5];

        for (int i =0;i<5;i++){
            System.out.println("numero añadido " + random );
            numeros[i]= (byte) random;
            random= (int) ((Math.random()*10)+1);
        }
        salida.write(numeros);

        salida.flush(); // Asegurar que se envíen los datos antes de cerrar
        salida.close();

        //---------RECIBIR----------------------
        Socket socket2 = new Socket("localhost",5555);
        byte [] recibir = new  byte[3];
        DataInputStream entrada=new DataInputStream(socket2.getInputStream());
        recibir=  entrada.readAllBytes();

        System.out.println("la suma es " + recibir[0]);
        System.out.println("el mayor es " + recibir[1]);
        System.out.println("el menor es " + recibir[2]);
    }
}
