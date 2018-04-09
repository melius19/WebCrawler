package CHAP16;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {

	public static void main(String[] args) {
		try{
			String serverIp = "192.168.3.21";
			System.out.println("Server IP :" + serverIp);
			Socket socket = new Socket(serverIp,7777);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println("MSG from Server :" + dis.readUTF());
			System.out.println("connection closing");
			
			dis.close();
			socket.close();
			System.out.println("connection closed");
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
