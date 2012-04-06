package test.Konami;

import java.net.*;
import java.io.*;

public class SocketLis {
	
	private String readIn;
	private Socket sock;
	private ServerSocket serverConnect;

	

	public void listen(GUIServer gs){
		
		
		try {
			serverConnect = new ServerSocket(gs.
					getServerPortNumber());
			sock = serverConnect.accept();
			InputStream dataIn = sock.getInputStream();
			BufferedReader inside
	          = new BufferedReader(new InputStreamReader(dataIn));
			readIn = inside.readLine();
		} catch (IOException e) { 
			
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
