#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
int segundos = 0;

void tiempotranscurrido(int sig) {
    segundos += 5;  // Incrementar el tiempo transcurrido
    printf("Tiempo transcurrido: %d segundos\n", segundos);
    alarm(5);  // Programar la próxima alarma en 5 segundos
}

int main() {
    signal(SIGALRM, tiempotranscurrido);  // Configurar la señal
    alarm(5);  // Programar la  alarma

    while (1) {
        pause();  // se pausa hasta que la alarma se active
    }

    return 0; 
}
