package koanami.pack;

import java.io.*;
import java.net.*;

public class ServerAccess {
	
	public Socket connectSocket;
	public PrintWriter out;
    private String serverIp;
    private int serverPort;
    
    

	public ServerAccess(String inputserverIp, int inputserverPort){
		
		this.serverIp = inputserverIp;	
		this.serverPort = inputserverPort;
		//this.gui = GUI;
		
}
		
	public void connect(String outPutText) throws IOException{	

//connection objects for writing and reading from the server 
		connectSocket = new Socket(serverIp, serverPort);
		out = new PrintWriter(connectSocket.getOutputStream(), true);
	    out.println(outPutText);
	    out.close();
      
}    
    public void receive() throws IOException{  
    	
    	//boolean controlVar = true;
      
    	BufferedReader myBR = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
		String myServerString = "nothing yet";
		myServerString = myBR.readLine();
		while (myServerString != null){
			myBR.readLine();
			myServerString = myBR.readLine();
		}
		myBR.close();
		
		
		
	
		
}

// used for closing the socket	
	public void connectClose() throws IOException{
		connectSocket.close();
		
		
	}
 }
