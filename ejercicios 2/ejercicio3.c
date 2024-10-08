#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
    pid_t pid1;
    pid1 = fork();  //creamos el primer hijo
    if (pid1>0){ 
    wait(NULL); // P1 ESPERA A P2
    printf("p1\n");
    }
    //P2 CONTINUA
    else{ 
    		//P2 CREA A P3
	    	if(fork()>0){ 
	    		//P2 PRIMERO CREA A P4 Y LUEGO ESPERA
	    		if(fork()>0){ //P2 DEBE ESPERAR P4
	    		wait(NULL);
	    		}
	    		else{ //segundo hijo(p4)
	    			if(fork()>0){//P4 CREA A P6
	 			//P4 ESPERA A P6
	    			wait(NULL);
	    			printf("p4\n");
	    			}
	    			else{
	    			printf("p6\n");
	    			}
	    		
	    		}
	    	wait(NULL); //P2 TAMBIEN ESPERA A P3
	    	printf("p2\n");
	    	}
	    	
	    	else{
	    		if(fork()>0){//P3 DEBE CREAR A P5
	    		wait(NULL);
	    		printf("p3\n");
	    		
	    		}
	    		else{
	    		printf("p5\n");
	    		
	    		}
	
	    	}
    }
    
    
    
    return 0;
}