package ufersa.sd.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacao {
	
	public static void main(String[] args) {
		
		//cria uma thread e deixa em standbye
//		ExecutorService e = Executors.newSingleThreadExecutor();
		//criando um pool de Threads com 2 Threads
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		for (int i = 1; i < 6; i++) {
			Tarefa t = new Tarefa(i);
			e.execute(t);
		}
		//destruindo as threads criadas
		e.shutdown();
	}
}
