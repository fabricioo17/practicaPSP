#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>

void imprimirfecha(int señal){
    time_t tiempo;
    time(&tiempo);
    struct tm *estructura;
    estructura=localtime(&tiempo);


prntf("fecha: %s"+ asctime(estructura));


}


int main(){


signal(SIGINT,imprimirfecha);

 // Obtener la hora actual al inicio
    time_t ahora;
    struct tm *estructura;
    time(&estructura);
    formatoNuevo = localtime(&estructura);
printf("fin de proceso %d  fecha: %s" , getpid() , asctime(estructura));

while (1)
{
    pause();
}

}