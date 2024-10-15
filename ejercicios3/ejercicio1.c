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
	time_t hora; 
    char *fecha;
     char buffer[100];
    
    time(&hora);
    fecha=ctime(&hora);
    
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