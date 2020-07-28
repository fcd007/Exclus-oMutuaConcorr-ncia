package ufersa.sd.regiaoCriticaReentrantLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Aplicacao {

	public static void main(String[] args) {
		
		//criando um pool de Thread com 2 threads
		ExecutorService e = Executors.newFixedThreadPool(2);
		
		ContaBancaria conta = new ContaBancaria();
		
		Cliente c1 = new Cliente(conta);
		Cliente c2 = new Cliente(conta);
		Cliente c3 = new Cliente(conta);

		e.execute(c1);
		e.execute(c2);
		e.execute(c3);

		
		e.shutdown();
		
		//verifica se tudo terminou
		while (!e.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} 

		System.out.println("Saldo atual = R$ " + conta.getSaldo());
	}

}
