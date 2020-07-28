package ufersa.sd.leituraEscritaReadWriteLocks;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class Informacao {

	//lock de exclusão mútua - ou uma usa ou nenhuma usa.
	private ReentrantReadWriteLock LEL = new ReentrantReadWriteLock();
	//precisamos pegar um par de locks
	private ReadLock leitura1 = LEL.readLock();
	private WriteLock escrita1 = LEL.writeLock();
	
	private String info = "AAAAAAAAAA";
	private Random random = new Random();
	
	public String getInfo() {
		//realizando a leitura por multiplas threads
		leitura1.lock();
		try {
			return info;
		} finally {
			//realizando liberação do lock
			leitura1.unlock();
		}
	}
	
	public void setInfo() {
		//tratando a região crítica para bloquear o recurso na escrita
		escrita1.lock();
		
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
			escrita1.unlock();
		}
	}
}
