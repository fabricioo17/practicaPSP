package ProdCons2;

public class Cola {
    private int[] numeros= new int[5] ;
    private boolean disponible = false;

    
    public synchronized int get(int valor) {
		int posicion= valor%5;
         // Queda a la espera hasta que la cola se llene ("mientras cola vacía espero en wait()")
    	  while (!disponible) {
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  //Una vez hay valor disponible se devuelve
    	  disponible = false;
    	  notify();
    	  return numeros[posicion];
    	}

    public synchronized void put(int valor) {
		int posicion = (valor %5);
     // Queda a la espera hasta que la cola se vacíe ("mientras haya datos en la cola espero en wait()")
    	  while (disponible){
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }

		  numeros[posicion]=((int)(Math.random()*10)+1);
		System.out.println(" produce: " +numeros[posicion]);
	    	  disponible = true;

    	  notify();
    	}


    
}
