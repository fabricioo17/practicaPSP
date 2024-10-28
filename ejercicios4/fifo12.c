#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>



int factorial(int n) {
    if (n == 0) return 1;
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

int main() {
    int fd1, fd2;
    int number;
    int result;

    // Abrir el pipe FIFO1 para leer
    fd1 = open("fifo1", O_RDONLY);
    read(fd1, &number, sizeof(number));
    close(fd1);

    // Calcular el factorial
    result = factorial(number);

    // Abrir el pipe FIFO2 para escribir
    fd2 = open("fifo2", O_WRONLY);
    write(fd2, &result, sizeof(result));
    close(fd2);

    return 0;
}
