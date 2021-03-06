package jelloChat.Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server implements Runnable {
	
	private DatagramSocket socket;
	private int port;
	private boolean running = false;
	private Thread run, manage, send, receive;

	public Server(int port) {
		
		this.port = port;
		try {
			
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			
			e.printStackTrace();
			return;
		}
		
		run = new Thread(this, "Server");
		run.start();
		
	}
	
	public void run() {
		running = true;
		System.out.println("Server started on port: " + port);
		manageClient();
		receive();
		
	}
	
	private void manageClient() {
		
		manage = new Thread("Manage"){
			
			public void run() {
				
				while (running){
					
					//Managing
					
				}
				
				
			}
		};
		manage.start();
		
	}
	
	private void receive() {
		
		receive = new Thread("Receive") {
			
			public void run() {
				
				while (running) {
					
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						
						socket.receive(packet);
						packet.getAddress();
						packet.getPort();
						
					} catch (IOException e) {
						
						// TODO Auto-generated catch block
						e.printStackTrace();
						
					}
					
					String string = new String(packet.getData());
					System.out.println(string);
					
				}
			}
		};
		 receive.start();
		
		
	}
}
