package ufersa.sd.regiaoCriticaReentrantLock;

public class Cliente implements Runnable {
	
	private ContaBancaria conta;
	
	//todo cliente vai receber a conta bancário - usando a mesma
	//ou seja eles irão utilizar o mesmo recurso - área crítica.
	public Cliente(ContaBancaria conta) {
		super();
		this.conta = conta;
	}
	
	@Override
	public void run() {
		
		try {
			
			for (int i = 1; i < 6; i++) {
				conta.depositar(150);
				Thread.sleep(200);
				conta.sacar(150);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
