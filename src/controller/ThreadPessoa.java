package controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread{
	//Variaveis que serão usadas em todas threads
	private int idPessoa;
	private Semaphore semaforo;
	//metodo contrutor
	public ThreadPessoa(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		pessoaAndando();
		//Iniciar seção critica
		try {
			semaforo.acquire();
			pessoaPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//caso de algum erro no metodos....
			semaforo.release();
		}
		
		
	}
	//Parte em que a pessoas cruzam a ponte de 1 a 2 segundos
	private void pessoaPorta() {
		//varivel randomica para tempo de cruzar a porta
		int tempo = (int) (Math.random() * 1 + 1);
		//pausar a thread		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Exibir quem cruzou a porta
		System.out.println("A " + idPessoa + "º pessoa cruzou a porta.");
	}
	public void pessoaAndando(){
		//variavel que serão usadas no metodo
		int dTotal = 200;
		int dPer = 0;
		int v = (int) (Math.random() * 2 + 4);
		//percorrer o tempo no corredor
		while (dPer < dTotal) {
			dPer += v;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//exibir quem chegou a ponte
		System.out.println("A " + idPessoa + "º pessoa chegou na ponte.");
	}
}
