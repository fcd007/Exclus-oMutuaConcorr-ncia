package ufersa.sd.leituraEscritaReentrantLock;

public class Escritor implements Runnable {

	private Informacao informacao;
	
	public Escritor(Informacao informacao) {
		this.informacao = informacao;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			informacao.setInfo();
		}
	}
}
