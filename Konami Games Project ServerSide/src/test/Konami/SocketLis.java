package test.Konami;

import java.net.*;
import java.io.*;

public class SocketLis {
	
	 String readIn = "init";
	 Socket sock;
	 ServerSocket serverConnect;

	public void listen(GUIServer gs) throws IOException{
		serverConnect = new 
				ServerSocket(gs.getServerPortNumber());
		sock = serverConnect.accept();
		BufferedReader inside = new BufferedReader(new InputStreamReader(sock.getInputStream())); 
		while (readIn != null){
			readIn = inside.readLine();
			gs.getGridName().setText(readIn);
			System.out.println(readIn);
		}
}
	
	public void close() throws IOException{
		sock.close();
		serverConnect.close();
	}
	
	public String getReadIn() {
		return readIn;
	}
	
	public void setReadIn(String readIn) {
		this.readIn = readIn;
	}
}
