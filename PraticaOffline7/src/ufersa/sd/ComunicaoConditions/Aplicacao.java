package ufersa.sd.ComunicaoConditions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacao {
	
	private static int NUN_CARROS = 5;
	
	public static void main(String[] args) {
		
		//criando um pool de threads com o valor de carros + 1 do semáforo
		ExecutorService exec = Executors.newFixedThreadPool(NUN_CARROS + 1);
		
		Semaforo semaforo = new Semaforo();
		exec.execute(semaforo);
		
		for (int i = 1; i <= NUN_CARROS; i++) {
			Carro carro = new Carro(i, semaforo);
			exec.execute(carro);
		}
		
		exec.shutdown();
	}
}
