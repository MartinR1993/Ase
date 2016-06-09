package connector;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;


public class connector {
	public static void main(String[] args) {
		
	
		try {
			Socket socket = new Socket("localhost", 8000);
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());

			BufferedReader scan = new BufferedReader (new InputStreamReader(System.in));
			
//			os.writeBytes(scan.readLine()+ "\r\n");
			os.writeBytes("B 200\r\n");
			os.writeBytes("Q\r\n");

			
		} catch (Exception e) {
			System.err.println("Exception:  " + e);
	} 
	}
}