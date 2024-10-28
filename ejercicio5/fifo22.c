#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <time.h>

int factorial(int n) {
    if (n == 0) return 1;
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

int main(){
    int resultado;
    int fd;
    int number;


    fd=open("fifo1",O_RDONLY);
    read(fd, &number, sizeof(number));
    resultado=factorial(number);
    close(fd);
    

    fd=open("fifo1",O_WRONLY);
    write(fd,&resultado,sizeof(resultado));
    close(fd);
 return 0;

}