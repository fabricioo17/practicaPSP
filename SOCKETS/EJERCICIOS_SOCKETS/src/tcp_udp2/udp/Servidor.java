package tcp_udp2.udp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        InetAddress inet = InetAddress.getLocalHost();
        byte[] recibido = new byte[5];
        byte[] enviarResultado = new byte[5];
        DatagramSocket socket= new DatagramSocket(5555);



        while (true) {
            DatagramPacket packet= new DatagramPacket(recibido,recibido.length);
            socket.receive(packet);

            //-------------------ENVIAR

            //----------------------enviar---------------------------//

            enviarResultado[0]= (byte) Suma(recibido);
            enviarResultado[1]= (byte) Mayor((recibido));
            enviarResultado[2]= (byte) Menor(recibido);
            int puertoEnviar=34567;
            DatagramPacket packet2= new DatagramPacket(enviarResultado,enviarResultado.length,inet,puertoEnviar);
            socket.send(packet2); //enviamos el paquete


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
