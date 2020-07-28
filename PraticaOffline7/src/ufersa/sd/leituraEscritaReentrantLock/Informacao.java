package ufersa.sd.leituraEscritaReentrantLock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Informacao {

	//lock de exclusão mútua - ou uma usa ou nenhuma usa.
	private ReentrantLock lock = new ReentrantLock();
	
	private String info = "AAAAAAAAAA";
	private Random random = new Random();
	
	public String getInfo() {
		//realizando o lock do recurso para uso da Thread
		lock.lock();
		try {
			return info;
		} finally {
			//realizando liberação do recurso para outras threads
			lock.unlock();
		}
	}
	
	public void setInfo() {
		//tratando a região crítica para bloquear o recurso
		lock.lock();
		
		try {
			info = "";
			
			for (int i = 0; i < 10; i++) {
				char c = (char) (random.nextInt(26) + 65);
				info += c;
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		} finally {
			//liberando o recurso para as demais Threads
			lock.unlock();
		}
	}
}
