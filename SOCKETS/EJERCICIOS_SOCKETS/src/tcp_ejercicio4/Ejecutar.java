package tcp_ejercicio4;

import java.io.IOException;

public class Ejecutar {
    public static void main(String[] args) throws IOException {
    Cliente cliente= new Cliente(1);
        Cliente cliente2= new Cliente(2);
    cliente.start();
    cliente2.start();
    }
}
