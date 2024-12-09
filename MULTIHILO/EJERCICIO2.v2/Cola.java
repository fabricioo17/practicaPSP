package ProdCons2;

import java.util.concurrent.ArrayBlockingQueue;

public class Cola {
	private static final ArrayBlockingQueue<Integer> numeros = new ArrayBlockingQueue<>(5); ;
    private boolean disponible = false;


	// Método para obtener un número de la cola
	public int get() throws InterruptedException {
		return numeros.take(); // Toma un elemento de la cola (bloquea si está vacía)
	}

	// Método para agregar un número a la cola
	public  void put(int valor) throws InterruptedException {
		numeros.put(valor); // Agrega un elemento a la cola (bloquea si está llena)
		System.out.println("Produce: " + valor);
	}

    
}
