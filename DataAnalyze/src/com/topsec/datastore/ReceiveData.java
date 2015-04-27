package com.topsec.datastore;
import java.io.IOException;  
import java.net.DatagramPacket;  
import java.net.DatagramSocket;  

public class ReceiveData {
	public void receivedata() throws IOException {
		int servPort = 5514;
		@SuppressWarnings("resource")
		DatagramSocket socket=new DatagramSocket(servPort);
		DatagramPacket packet=new DatagramPacket(new byte[10240], 10240);

		while(true){
            socket.receive(packet);
            String str_receive = new String(packet.getData(),0,packet.getLength());
            new Thread(new SplitData(str_receive)).start();
        }
	}
}