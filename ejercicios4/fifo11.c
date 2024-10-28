#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <time.h>


int main() {
    int fd1, fd2;
    int number;
    int result;

    // Crear los pipes FIFO
    mkfifo("fifo1", 0666);
    mkfifo("fifo2", 0666);

    // Generar un número aleatorio
    srand(time(NULL));
    number = rand() % 11; // Número entre 0 y 10
    printf("Número generado: %d\n", number);

    // Abrir el pipe FIFO1 para escribir
    fd1 = open("fifo1", O_WRONLY);
    write(fd1, &number, sizeof(number));
    close(fd1);

    // Abrir el pipe FIFO2 para leer el resultado
    fd2 = open("fifo2", O_RDONLY);
    read(fd2, &result, sizeof(result));
    close(fd2);

    printf("El factorial de %d es: %d\n", number, result);

   
    return 0;
}
