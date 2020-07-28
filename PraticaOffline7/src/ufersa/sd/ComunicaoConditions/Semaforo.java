package ufersa.sd.ComunicaoConditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Semaforo implements Runnable {

	/* problema de leitura e escrita do atributo
	 * assim temos que realizar uma tratativa do lock
	 */
	/* quando adicionado o lock, podemos ter o lock
	 * bloqueado, o semáforo está bloqueado, o lock
	 * fica em espera para sempre, em loop de verdadeiro
	 * irá guardando o lock ser liberado
	 */
	/* as conditions são usadas dentro do cenário
	 * para as threads se comuniquem de forma segura
	 * 
	 */
	
	private boolean  aberto = false;
	//proteção de aŕea crítica - com um lock
	private ReentrantLock lock = new ReentrantLock();
	//uma condition sempre estará atrelada a um lock
	private Condition condition = lock.newCondition();
	
	@Override
	public void run() {
		while (true) {
			lock.lock();
			try {
				aberto = !aberto;
				System.out.println("Semáforo aberto : " + aberto);
				
				//verifica se o semáforo está aberto
				if(aberto) {
					//acorda as threads que está no estado de await
					//aguardando, logo temos que avisa todas que estão
					//esperando liberar o lock, assim todas voltam para 
					//o escalonador, e apenas uma irá pegar o lock
					condition.signalAll();
				}
				
			}finally
			{
				lock.unlock();
			}
			
			try {
				Thread.sleep(1000 + (int) (Math.random()* 4000));
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atravessar(int id) {
		lock.lock();
		try {
			while(!aberto) {
				System.out.println("[Carro " + id + "] Aguardando");
				//faz a thread parar e libera o lock, depois recebe um aviso
				// de outra thread para retornar a execução
				condition.await();
			}
			
			System.out.println("[Carro " + id + "] Atravessou");
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
