#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
    pid_t pid1,pid2,pid3,pid4,pid5;
   
   
   
    pid1 = fork();  //creamos el primer hijo
    if (pid1>0){ 
    wait(NULL); // P1 ESPERA A P2
    printf("p1\n");
    }
    //---------P2 CONTINUA---------------------------/
    else{ 
    		pid2= fork();//P2 CREA A P3
    		
    		
	    	//---P2 continua-----------------------//
	    	if(pid2>0){ 
	    	//--------P2 PRIMERO CREA A P4 Y LUEGO ESPERA-------------------//
	    		pid3=fork();
	    		//----------------P2 espera-----------------//
	    		if(pid3>0){ 
	    		wait(NULL);
	    		}
	    		
	    		//------------continuaP4--------------//
	    		else{ 
	    		
	    		//----------------P4 crea a P6--------------------//
	    		pid4=fork();
	    		
	    		//-------------------continua P4 y espera a P6-------------//
	    			if(pid4>0){
	 			//P4 ESPERA A P6
	    			wait(NULL);
	    			printf("p4\n");
	    			}
	    			
	    			//-----------continuaP6--------------//
	    			else{
	    			printf("p6\n");
	    			}
	    		
	    		}
	    	wait(NULL); //P2 TAMBIEN ESPERA A P3
	    	printf("p2\n");
	    	}
	    	
	    	
	    	//---P3 continua-----------------------//
	    	else{
	    	
	    	//---------p3 crea a p5----------//
	    	pid5=fork();
	    	//---------continua p3 y espera--------//
	    		if(pid5>0){//P3 DEBE CREAR A P5
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
