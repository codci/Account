package first;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WrightXML {

	static Document doc;
	static Element rootElement;
	static String path = "C:\\xml\\temp.xml";
	static File f1 = new File(path);
	
	static void openXML(){
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
			//Проверяем наличае файла
			if(f1.exists() == true){
				//System.out.print("Файл модифицирован.");
				doc = docBuilder.parse(path);
			}
			else{
				doc = docBuilder.newDocument();
				rootElement = doc.createElement("bank");
				doc.appendChild(rootElement);
				//System.out.println("Файл создан.");
			}
			
			rootElement = doc.getDocumentElement();				
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void saveXML(){
		try {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		
		transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource sourse = new DOMSource(doc);
		
		StreamResult result = new StreamResult(f1);
		transformer.transform(sourse, result);
		
		
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	static void createAccountXML(int id,int pas,double balans,int dateY,int dateM,int typeAccount){
		WrightXML.openXML();
		
		Element account = doc.createElement("account");
		rootElement.appendChild(account);
		
		
		Attr attr1 = doc.createAttribute("id");
		attr1.setValue(Integer.toString(id));
		account.setAttributeNode(attr1);
		
		Attr attr2 = doc.createAttribute("password");
		attr2.setValue(Integer.toString(pas));
		account.setAttributeNode(attr2);
		
		Element balance = doc.createElement("balance");
		balance.appendChild(doc.createTextNode(Double.toString(balans)));
		account.appendChild(balance);
		
		Element date1 = doc.createElement("dateY");
		date1.appendChild(doc.createTextNode(Integer.toString(dateY)));
		account.appendChild(date1);
		
		Element date2 = doc.createElement("dateM");
		date2.appendChild(doc.createTextNode(Integer.toString(dateM)));
		account.appendChild(date2);
		
		Element type = doc.createElement("type");
		type.appendChild(doc.createTextNode(Integer.toString(typeAccount)));
		account.appendChild(type);
		
		WrightXML.saveXML();
	}
	
	static void modifyXML(int id,double balance,int dateY,int dateM){
		WrightXML.openXML();
		
		NodeList accountList = doc.getElementsByTagName("account");

		for(int i = 0; i < accountList.getLength();i++){
			Element e = (Element) accountList.item(i);
			
			if (Integer.parseInt(e.getAttribute("id"))==id){
				NodeList childList = accountList.item(i).getChildNodes();
				for(int j = 0; j < childList.getLength();j++){
					
					Node node = childList.item(j);
					
					if("balance".equals(node.getNodeName()))
						node.setTextContent(Double.toString(balance));
					
					if("dateY".equals(node.getNodeName()))
						node.setTextContent(Integer.toString(dateY));
					
					if("dateM".equals(node.getNodeName()))
						node.setTextContent(Integer.toString(dateM));
				}	
			}
		}
		
		WrightXML.saveXML();
	}
}
