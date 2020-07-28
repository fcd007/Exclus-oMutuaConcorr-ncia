package ufersa.sd.regiaoCriticaReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ContaBancaria {
	//garantindo que teremos sincronismo
	/* permite que somente uma thread realize o lock
	 * ele garante o sincronismo, nunca 2 threads somente 1 com
	 * o recurso que está a região crítica.
	 */
	private ReentrantLock lock = new ReentrantLock();
	
	private double saldo;
	
	public void sacar(double valor) {
		//garantindo que apenas uma thread acesse o recurso saldo
		lock.lock();
		try {
			this.saldo -= valor;
		} finally {
		// liberando o recurso saldo para outras threads
			lock.unlock();
		}
	}
	
	public void depositar(double valor) {
		//garantindo que apenas uma thread acesse o recurso saldo
		lock.lock();
		try {
			this.saldo += valor;
		} finally {
		// liberando o recurso saldo para outras threads
			lock.unlock();
		}
	}
	
	public double getSaldo() {
		return saldo;
	}
}
