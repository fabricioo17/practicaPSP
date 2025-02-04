package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente2 {
    public static void main(String[] args) throws IOException {


        byte [] numero = new  byte[1024];
        DatagramSocket socket=new DatagramSocket(1234); //local

        DatagramPacket packet = new DatagramPacket(numero,numero.length);//envio

        socket.receive(packet);
        String num =new String (packet.getData()).trim();
        System.out.println("numero recibido " + num);
        int i ;

        //-------------Enviar factorial
        InetAddress inet =InetAddress.getLocalHost();
        String numeroEnviar= factorial(Integer.parseInt(num));
        numero=numeroEnviar.getBytes();
        DatagramPacket enviar= new DatagramPacket(numero,numero.length,inet,5555);
        socket.send(enviar);
    }

    public static String factorial(int valor){
        int num=1;
        for (int i=1;i<=valor;i++ ){
            num=num*i;
        }

        return String.valueOf(num);
    }
}
