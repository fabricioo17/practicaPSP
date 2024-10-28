#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h> 
#include <string.h>

int main (){
pid_t pid1;
int fd[2];
char buffer [1024];
//----------crear el pipe--------------//
pipe(fd);

pid1=fork();



if(pid1>0){
 // Enviar números al pipe
        while (1) {
            printf("Introduce un número (o '+' para finalizar): ");
            fgets(buffer, sizeof(buffer), stdin); // Leer entrada del usuario

            if (buffer[0] == '+') {
                write(pipe_fd[1], buffer, 2); // Enviar '+' al hijo
                break; // Salir del bucle
            }

            // Convertir la entrada a número y enviar al pipe
            numero = atoi(buffer);
            write(pipe_fd[1], &numero, sizeof(numero));
        }


wait(NULL);
}

else{



}




}