package koanami.pack;

import javax.xml.parsers.*;

import org.xml.sax.InputSource;
import org.w3c.dom.*;

import java.io.*;


public class XmlReceived {

//XmlReceived is used to process the XML data and 
//Parsers the data and prints it on the grid	
	
	private String xmlName = "Null";
	private String xmlAddress = "Null";
	private String xmlCommand = "Null";
	private String xml;
	public 	GUIServer gui;
	
	
public XmlReceived (String Xml, GUIServer gui){
	this.xml = Xml;
	this.gui = gui;
	
	}

//Converters the input element type to a string type

public static String getCharacterDataFromElement(Element e) {
	Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
		       			CharacterData cd = (CharacterData) child;
		    return cd.getData();
		    }
		    return "Please check the XML.";
}

public void process(){

//This is the main method of this class, it process XML data	
	
	try {
        DocumentBuilderFactory dbf =
            DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        
        Document doc = db.parse(is);
    
// removed the command from the XML message.
        NodeList nodesMessage = doc.getElementsByTagName("Message");
        Element elementMessage = (Element) nodesMessage.item(0);
        NodeList myCommands = elementMessage.getElementsByTagName("Command");
        Element commandStr = (Element) myCommands.item(0);
        String clientCommand = getCharacterDataFromElement(commandStr);
        
// command to be send to the server
        
        System.out.println("Server please" +
        				" process this command " + clientCommand); 
        
        this.xmlCommand = clientCommand;
        
        NodeList nodes = doc.getElementsByTagName("Row");
       
// loops thought the XML Message for values.
        for (int x = 0; x < nodes.getLength(); x++ ){
        
        
			        Element element = (Element) nodes.item(x); //what I need to loop
			        
			        NodeList name = element.getElementsByTagName("Description");
			        Element line = (Element) name.item(0); 
			        
			        String conVar = getCharacterDataFromElement(line);
			        conVar = conVar.replace("\"", "");
			        String nameObj = "Name";
			        String addressObj = "Address";
			        
			        

			        
					NodeList addr = element.getElementsByTagName("Value");
			        Element lineaddress = (Element) addr.item(0);
			   
			        	if (conVar.equals(addressObj)){
			                String xmlAddress = getCharacterDataFromElement(lineaddress);
			                xmlAddress = xmlAddress.replace("\"", "");
			                this.xmlAddress = xmlAddress;  
			        	}
			        	if (conVar.equals(nameObj)){
			                String xmlName = getCharacterDataFromElement(lineaddress);
			                xmlName = xmlName.replace("\"", "");
			                this.xmlName = xmlName;	
			        	}
               
        	}
            
    }catch(Exception e){
    	
    System.out.println ("issue in the XML processing");
    }
}

	public String updateNameGrid(){
		return this.xmlName;
				
}
	public String updateAddressGrid(){
		return this.xmlAddress;
		
}
	public String updateCommandGrid(){
		return this.xmlCommand;		
		
}

}
