#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>

FILE *archivo;
void escrbirArchivo(int signal){

time_t tiempo; 

time (&tiempo);

struct tm *estructura=localtime(&tiempo);

// Abrir el archivo en modo "append"
    archivo = fopen("fichero.txt", "a");
    if (archivo!= NULL) {
        fprintf(archivo, "Intento de detener el programa en: %s\n", asctime(estructura));
        fclose(archivo);
    } else {
        perror("Error al abrir el archivo");
    }


}

int main(){
signal(SIGINT,escrbirArchivo);


while (1)
{
    pause();
}

}

