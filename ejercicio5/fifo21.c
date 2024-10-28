#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <time.h>
int main(){
    int fd1;
    int number;
    int resultado;

     // Crear los pipes FIFO
    mkfifo("fifo1", 0666);

 // Generar un número aleatorio
    srand(time(NULL));
    number = rand() % 11; // Número entre 0 y 10
    printf("Número generado: %d\n", number);

    fd1= open("fifo1",O_WRONLY);
        write(fd1,&number,sizeof(number));
    close(fd1);

    fd1=open("fifo1",O_RDONLY);
    read(fd1,&resultado,sizeof(resultado));

    printf("El factorial de %d es: %d\n", number, resultado);
    close(fd1);
 return 0;
}