package ufersa.sd.threads;

public class Tarefa implements Runnable {
	
	private int id;
	
	public Tarefa(int id) {
		this.id = id;
	}
	
	@Override
	public void run() {
		System.out.println("Tarefa " +  id + " iniciando");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Tarefa " + id + "terminando");
	}
	
}