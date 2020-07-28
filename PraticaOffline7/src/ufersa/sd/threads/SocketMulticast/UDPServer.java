package ufersa.sd.threads.SocketMulticast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPServer {

	public static void main(String[] args) throws Exception {
		
		InetAddress addr = InetAddress.getByName("228.0.0.1");
		try(MulticastSocket socket = new MulticastSocket(34001)) {
			socket.joinGroup(addr);
			byte[] buffer = new byte[1024];
			
			DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
			System.out.println("Servidor: aguardando datagrama...");
			socket.receive(pacote);
			
			byte[] clienteData = pacote.getData();
			String clienteDataStr = new String(clienteData, 0, pacote.getLength());
			
			System.out.println("Servidor: dado recebido do cliente => " + clienteDataStr);
			
			/* para sair do grupo use socket.leaveGroup*/
			/*pode criar uma estância que recupera o serviço
			 * apenas fazendo a criação de uma nova execução 
			 * e pedindo para entrar no grupo.
			 */
		}
	}
}
