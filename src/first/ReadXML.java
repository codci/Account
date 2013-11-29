package first;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {
	
	static File f1 = new File("C://xml//temp.xml");
	static NodeList nodeList;
	//static Document doc;
	
	static void startRead(){
		
		try {
			//DocumentBuilder db;
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		
			Document doc;
			doc = db.parse(f1);
		
			doc.getDocumentElement().normalize();
			nodeList = doc.getElementsByTagName("account");
		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static UniversalAccount initialize(int id, int pass){
			ReadXML.startRead();
		
			for(int i =0; i < nodeList.getLength(); i++){
				
				Node tempNode = nodeList.item(i);
				Element e = (Element) tempNode;
				
				if(Integer.parseInt(e.getAttribute("id")) == id){
					
					if(Integer.parseInt(e.getAttribute("password")) == pass){
						UniversalAccount ua = null; //создаем обьект с которым будем работать
						
						if(tempNode.getNodeType() == Node.ELEMENT_NODE){
							double balance = Double.parseDouble(e.getElementsByTagName("balance").item(0).getTextContent());
							int dateY = Integer.parseInt(e.getElementsByTagName("dateY").item(0).getTextContent());
							int dateM = Integer.parseInt(e.getElementsByTagName("dateM").item(0).getTextContent());
							int type = Integer.parseInt(e.getElementsByTagName("type").item(0).getTextContent());
							
							ua = UniversalAccount.accountFactory(type,id, balance, dateY, dateM);
							//System.out.println("lfyyst:" + balance + " " + date + " " + type);
							/*ua = UniversalAccount.accountFactory(
									Integer.parseInt(e.getElementsByTagName("type").item(0).getTextContent()),
									id,
									Integer.parseInt(e.getElementsByTagName("balance").item(0).getTextContent()),
									Integer.parseInt(e.getElementsByTagName("dateY").item(0).getTextContent()),
									Integer.parseInt(e.getElementsByTagName("dateM").item(0).getTextContent())
									);*/
							return ua;
						}
					}
				}
			}
		return null;
	}
}
