package test.Konami;

import java.io.*;
import java.net.*;

public class ServerAccess {
	
	Socket connectSocket;
	PrintWriter out;
    String serverIp;
    int serverPort;
	
	public ServerAccess(String inputserverIp, int inputserverPort){
		
		this.serverIp = inputserverIp;	
		this.serverPort = inputserverPort;
		
}
		
	public void connect(GUIClient GUI, String outPutText) throws UnknownHostException, IOException{	

      connectSocket = new Socket(serverIp, serverPort);
      out = new PrintWriter(connectSocket.getOutputStream(), true);
      out.println(outPutText); 
      
        	
}
	
	public void connectClose() throws IOException{
	
		out.close();
		connectSocket.close();
		
		
		
	}
 }
