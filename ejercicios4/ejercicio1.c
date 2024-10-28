#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h> 
#include <string.h>
int main() {
	pid_t pid1;  
	int fd[2];  //creamos el array para leer y escribir
	pipe(fd); //creamos el pipe
     char conjunto[100]; //aqui almacenaremos lo que obtengamos al leer
	time_t hora;  //creaoms una variable de time 
    char *fecha;
    time(&hora);  // obtendremos los milisegundos hasta la fecha acutal y la almacenamos en esta variable
    fecha=ctime(&hora); // con ctime transformamos los milisegundos a un formato de fecha y lo igualamos al punto de char *fecha
    
	pid1=fork();
	if(pid1>0){
	write(fd[1], fecha, strlen(fecha) + 1); 
	close(fd[1]);
	wait(NULL);
	}
	else{
	read(fd[0],buffer,sizeof(buffer));
	close(fd[0]);
	printf("%s",buffer);
	}

return 0;
}