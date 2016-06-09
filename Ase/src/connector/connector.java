package connector;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class connector {
	public static void main(String[] args) {



		try {
			boolean run = true;
			Socket socket = new Socket("localhost", 8000);
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());
			BufferedReader scan = new BufferedReader (new InputStreamReader(System.in));

			while (run) {

				String command = scan.readLine().toString();

				os.writeBytes(command+ "\r\n");

				if (command.equals("Q")) {
					run = false;
					scan.close();
				}
			}


			is.close();
			os.close();
			socket.close();

		} catch (Exception e) {
			System.err.println("Exception:  " + e);
		} 
	}
}