#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void funcionHijo1(int pipe1[2]);
void funcionHijo2(int pipe2[2], int pipe3[2]);
int esMultiploCinco(int num);

int main()
{
    pid_t hijo1;
    int pipe1[2];
    pipe(pipe1);
    hijo1 = fork();

    if (hijo1 == 0)
    { //--------------------hijo-------------------//
        close(pipe1[1]);
        funcionHijo1(pipe1);
    }
    else
    { //-------------padre----------------------//
        close(pipe1[0]);
        int cantidad;
        printf("Ingresa la cantidad de numeros: \n");
        scanf("%d", &cantidad);
        write(pipe1[1], &cantidad, sizeof(cantidad));
        close(pipe1[1]);
        wait(NULL);
    }
}

void funcionHijo1(int pipe1[2])
{
    int cantidad;
    pid_t hijo2;
    int pipe2[2];
    int pipe3[2];

    read(pipe1[0], &cantidad, sizeof(cantidad));
    close(pipe1[0]);

    pipe(pipe2); //-----------escribe desde proceso 2  y proceso 3 lee
    pipe(pipe3); //-----------escribe desde proceso 3  y proceso 2 lee
    hijo2 = fork();

    if (hijo2 == 0)
    {
        funcionHijo2(pipe2, pipe3);
    }
    else
    {
        close(pipe2[0]);
        close(pipe3[1]);
        int num;

        for (int i = 0; i < cantidad; i++)
        {
            printf("Ingresa el %d numero: \n", i + 1);
            scanf("%d", &num);
            write(pipe2[1], &num, sizeof(num));
        }

        close(pipe2[1]);

        //-----------ahora recibe los numeros e imprime------------//
        int suma1;
        int suma2;

        read(pipe3[0], &suma1, sizeof(suma1));

        read(pipe3[0], &suma2, sizeof(suma2));

        close(pipe3[0]);

        printf("La suma de los multiplos de 5 es: %d\n", suma1);

        printf("La cantidad de numeros que no son multiplos de 5 es: %d\n", suma2);

        wait(NULL);
    }
}

void funcionHijo2(int pipe2[2], int pipe3[2])
{
    int num;
    int suma1 = 0;
    int suma2 = 0;
    close(pipe2[1]);
    close(pipe3[0]);
    //-------------primero leemos los numeros
    while (read(pipe2[0], &num, sizeof(num)) > 0)
    {
        if (num % 5 == 0)
        {
            suma1 = suma1 + num;
        }
        else
        {
            suma2 = suma2 + 1;
        }
    }
    close(pipe2[0]);

    //-------------------escribimos los resultados-----------//
    write(pipe3[1], &suma1, sizeof(suma1));
    write(pipe3[1], &suma2, sizeof(suma2));
    close(pipe3[1]);
}

int esMultiploCinco(int num)
{
    int residuo;
    residuo = num % 5;
    return residuo;
}
