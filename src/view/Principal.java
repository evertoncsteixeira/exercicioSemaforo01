package view;
import java.util.concurrent.Semaphore;
import controller.ThreadPessoa;

public class Principal {

	public static void main(String[] args) {
		//Pegar numero de permissoes para cruzar a porta
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		//rodar as 4 thread para simular as pessoas 
		for (int i = 1; i < 5; i++ ){
			Thread tPessoa = new ThreadPessoa(i, semaforo);
			tPessoa.start();
		}

	}

}
