package tcp_udp2.udp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {

        byte[] numeros = new byte[5];
        DatagramSocket socket= new DatagramSocket(5555);


        while (true) {
            DatagramPacket packet= new DatagramPacket(numeros,numeros.length);
            socket.receive(packet);
            System.out.println("la suma es " + Suma(numeros));
            System.out.println("el mayor es " + Mayor(numeros));
            System.out.println("el menor es " + Menor(numeros));

        }
    }

    public static int Suma (byte[]numeros){
        int suma=0;
        for (int i=0 ; i <numeros.length;i++){
            System.out.println("numero recibido " + numeros[i]);
            suma=suma   + numeros[i];
        }
        return suma;
    }



    public  static int Mayor(byte [ ] numeros){
        int mayor=numeros[0],menor=numeros[0];
        for (int i=1 ; i <numeros.length;i++){
            if (numeros[i]>mayor){
                mayor=numeros[i];
            }
        }
        return  mayor;
    }
    public  static int Menor(byte [ ] numeros){
        int menor=numeros[0];
        for (int i=1 ; i <numeros.length;i++){
            if (menor>numeros[i]){
                menor=numeros[i];
            }
        }
        return  menor;
    }

}
