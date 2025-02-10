package tcp_udp2.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        byte[] recibido = new byte[1024];
        byte[] enviar=new byte[3];
        int suma;
        int mayor;
        int menor;
        int mensaje;
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            recibido = entrada.readAllBytes();
            enviar[0]= (byte) Suma(recibido);
            enviar[1]= (byte) Mayor((recibido));
            enviar[2]= (byte) Menor(recibido);
            entrada.close();
            socket.close();

            //---------------ENVIAR-----------------------------//
            Socket socket2 = serverSocket.accept();
            DataOutputStream salida = new DataOutputStream(socket2.getOutputStream());
            salida.write(enviar);
            salida.flush(); // Asegurar que se envíen los datos antes de cerrar
            salida.close();


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
