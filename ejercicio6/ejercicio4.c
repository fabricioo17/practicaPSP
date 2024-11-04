#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <time.h>

int count = 0;
int numVeces;
int intervalo;

void mostrarAlarma(int sig) {
    time_t now;
    time(&now);
    printf("Señal de alarma recibida a las %s", ctime(&now));
    count++;
    if (count >= numVeces) {
        printf("Alarma desactivada\n");
        exit(0);
    }
}

int main() {
    printf("¿Cuántas veces sonará la alarma?: ");
    scanf("%d", &numVeces);
    printf("¿Cada cuántos segundos se repetirá la alarma?: ");
    scanf("%d", &intervalo);

    signal(SIGALRM, mostrarAlarma);
    printf("Alarma activada\n");

    // Configurar la primera alarma
    alarm(intervalo);

    while (1) {
        pause(); // Esperar hasta que llegue una señal
        alarm(intervalo); // Programar la próxima alarma
    }

    return 0;
}
