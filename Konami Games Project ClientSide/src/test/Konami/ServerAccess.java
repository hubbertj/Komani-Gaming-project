package test.Konami;

import java.io.*;
import java.net.*;

public class ServerAccess {
	
	Socket connectSocket;
	PrintWriter out;
    String serverIp;
    int serverPort;
    BufferedReader myBR;
    String myServerString;
	
	public String getMyServerString() {
		return myServerString;
	}

	public void setMyServerString(String myServerString) {
		this.myServerString = myServerString;
	}

	public ServerAccess(String inputserverIp, int inputserverPort){
		
		this.serverIp = inputserverIp;	
		this.serverPort = inputserverPort;
		
}
		
	public void connect(GUIClient GUI, String outPutText) throws UnknownHostException, IOException{	
		
      connectSocket = new Socket(serverIp, serverPort);
      
      out = new PrintWriter(connectSocket.getOutputStream(), true);
      out.println(outPutText);
      out.close();
      
      //myBR = new BufferedReader(new InputStreamReader(connectSocket.getInputStream()));
      //myServerString = myBR.readLine();
      
      
        	
}
	
	public void connectClose() throws IOException{
		connectSocket.close();
		//myBR.close();		
	}
 }
