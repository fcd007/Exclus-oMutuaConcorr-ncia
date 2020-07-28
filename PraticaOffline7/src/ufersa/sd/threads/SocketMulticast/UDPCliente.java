package ufersa.sd.threads.SocketMulticast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPCliente {

	public static void main(String[] args) throws Exception {
		try(DatagramSocket socket = new DatagramSocket()) {
			String mensagem = "Mensagem1";
			byte[] buffer = mensagem.getBytes();
			
			InetAddress addr = InetAddress.getByName("228.0.0.1");
			
			DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, addr, 34001);
			
			socket.send(pacote);
			
			System.out.println("Cliente: enviando mensagem para o servidor " + mensagem);
		}
	}
}
