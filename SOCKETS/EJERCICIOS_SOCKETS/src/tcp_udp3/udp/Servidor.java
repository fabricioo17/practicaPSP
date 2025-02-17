package tcp_udp3.udp;

import tcp_udp3.Factura;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DatagramSocket socket = new DatagramSocket(5555);
        byte[] data = new byte[1024];  // recibir datos


        DatagramPacket packet = new DatagramPacket(data, data.length);

        // recibir el paquete
        socket.receive(packet);

        //  leer los datos recibidos
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data, 0, data.length);


        //  deserializar el objeto
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);


        Factura factura = (Factura) objectInputStream.readObject();


        System.out.println("Factura recibida: " + factura.getNumero());


        //---------------------------------------------------------
        //-----------CALCULAR----------------------------
        double iva = ObtenerIva(factura.getTipo(),factura.getImporte());
        double total= factura.getImporte() + iva   ;
        factura.setIva(iva);
        factura.setTotal(total);


        //---------ENVIAR-----------
        ByteArrayOutputStream enviar = new ByteArrayOutputStream();
        ObjectOutputStream escribir = new ObjectOutputStream(enviar);
        escribir.writeObject(factura);
        escribir.flush();

        byte[] data2 = enviar.toByteArray();

        InetAddress inetAddress =   InetAddress.getLocalHost();


        DatagramPacket packet2=new DatagramPacket(data2, data2.length,inetAddress,1234);
        socket.send(packet2);







        objectInputStream.close();

        
        socket.close();
    }
    public static double ObtenerIva(String tipo,double importe){
        double iva;
        if (tipo.equals("IGC")){

            iva= (0.07)*(importe);
        } else if (tipo.equals("ESP")) {
            iva= (0.21)*(importe);
        }
        else {
            iva= (0.15)*(importe);

        }


        return iva;
    }
}

