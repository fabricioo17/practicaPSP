#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
    pid_t pid1, pid2,pid3 ;
    pid1 = fork();  // Proceso padre crea un hijo
    
    if (pid1==0){
    	pid2 = fork();  // El hijo crea un nieto 
    }
     if (pid2==0){
    	pid3 = fork();  // El hijo crea un nieto 
    }
   
    
     if (pid1>0 || pid2>0 || pid3>0 ){ wait(NULL);}
     
     
    printf("mi pid es %d\n", getpid());
    printf("el pid de mi padre es %d\n", getppid());
    printf("Nuestra suma es: %d\n", (getpid() + getppid())); //produce huerfanos
    return 0;
}
