package ufersa.sd.leituraEscritaReentrantLock;

public class Leitor implements Runnable {

	private Informacao informacao;
	private String nome;
	
	public Leitor(String nome, Informacao informacao) {
		this.nome = nome;
		this.informacao = informacao;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				String texto = informacao.getInfo();
				System.out.println(nome + " => leu  "+  texto);
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
