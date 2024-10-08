#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
    pid_t pid1, pid2,pid3,pid4,pid5 ;
    pid1 = fork();  //creamos el primer hijo
    
    if (pid1==0){
    	pid2 = fork();  // El hijo1 crea un hijo2
    }
     if (pid1==0 && pid2>0){
    	pid3 = fork();  // El hijo1 crea un hijo3 
    }
    if (pid2==0){
    	pid4 = fork();  // El hijo2 crea un hijo4 
    }
   if (pid3==0){
    	pid5 = fork();  // El hijo3 crea un hijo5 
    }
    
     if (pid1>0 || pid2>0 || pid3>0 || pid4>0 || pid5>0 )  //preguntar como funciona wait null ahora que tiene dos hijos, espera a los dos o a uno entonces deberiamos poner doble null? preguntar tambien si luego de hacer el pid2 mantenemos los valores del pid1
     { wait(NULL);
     }
    printf("mi pid es %d\n", getpid());
    return 0;
}
