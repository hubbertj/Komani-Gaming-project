package test.Konami;

import java.net.*;
import java.io.*;

public class SocketLis {
	
	public String readIn = "";
	public Socket sock;
	public ServerSocket serverConnect;
	public String XML = "";
	public PrintWriter printS;
	private boolean controlVar;
	
	public SocketLis(){
		super();
	}
	
	public void close() throws IOException{
		sock.close();
		serverConnect.close();
		printS.close();
	}
	
	public String getReadIn() {
		return readIn;
	}
	
	public void setReadIn(String readIn) {
		this.readIn = readIn;
	}

	public String getXML() {
		return XML;
	}

	public void setXML(String xML) {
		XML = xML;
	}
	
	public void listen(GUIServer gs) throws IOException{
		controlVar = true;
		serverConnect = new 
				ServerSocket(gs.getServerPortNumber());
		sock = serverConnect.accept();
		BufferedReader inside = new 
				BufferedReader(new InputStreamReader(sock.getInputStream()));
		
		while (controlVar){
			readIn = inside.readLine();
				if(readIn == null){
					controlVar = false;
				}else{
					XML += readIn;
				}
		}
		
		try {
			Thread.sleep(2000);
			printS = new PrintWriter(sock.getOutputStream());
			printS.println("Confirmed: Message has been recieved");
			
		} catch (InterruptedException e) {
			System.out.println("Sleep Thread");
			
		}
		
		System.out.println(XML);
	}
}
