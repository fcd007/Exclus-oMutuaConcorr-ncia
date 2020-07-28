package ufersa.sd.leituraEscritaReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacao {

	public static void main(String[] args) throws Exception {
		
		Informacao info = new Informacao();
		int numLeitores = 5;
		int numEscritores = 5;
		
		ExecutorService exec = Executors.newFixedThreadPool(numEscritores + numLeitores);
		
		for (int i = 0; i < numLeitores; i++) {
			Leitor leitor = new Leitor("Leitor " + i, info);
			exec.execute(leitor);
		}
		
		for (int i = 0; i < numEscritores; i++) {
			Escritor escritor = new Escritor(info);
			exec.execute(escritor);
		}
		
		exec.shutdown();
	}
}
