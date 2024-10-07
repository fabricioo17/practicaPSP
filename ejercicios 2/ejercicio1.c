#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main() {
    pid_t pid1, pid2;
    pid1 = fork();  // Proceso padre crea un hijo
    pid2 = fork();  // El hijo crea un nieto y el padre un nuevo hijo 
    if (pid1>0){
    	wait(NULL);
    }
     if (pid2>0){
    	wait(NULL);
    }
    if (getpid()%2==0) {
    printf("mi pid es %d\n" , getpid());
    printf("mi pid del padre es %d\n  " , getppid());
    }
    if (getpid()%2!=0) {
    printf("mi pid es %d\n" , getpid());

    }
    return 0;
}
