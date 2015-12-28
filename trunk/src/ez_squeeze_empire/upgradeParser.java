/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ez_squeeze_empire;

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


/**
 *
 * @author Nick Stanish
 */
public class upgradeParser{
    private File file;
    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document doc;
    public upgradeParser(File a) throws ParserConfigurationException, SAXException, IOException{
          file = new File(a + "");
          dbf = DocumentBuilderFactory.newInstance();
          db = dbf.newDocumentBuilder();
          doc = db.parse(file);
          doc.getDocumentElement().normalize();
          
    }
    public void printNode(int a){
          System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
          NodeList nodeList = doc.getElementsByTagName("item");
          System.out.println("Information of all Upgrades");
          //for (int s = 0; s < nodeList.getLength(); s++) {
              Node fstNode = nodeList.item(a);
              if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element fstElmnt = (Element) fstNode;
                  NodeList name = fstElmnt.getElementsByTagName("name");
                  Element nameElement = (Element) name.item(0);
                  NodeList nameNL = nameElement.getChildNodes();
                  System.out.println("Name : "  + ((Node) nameNL.item(0)).getNodeValue());
                  NodeList description = fstElmnt.getElementsByTagName("description");
                  Element descriptionElement = (Element) description.item(0);
                  NodeList descriptionNL = descriptionElement.getChildNodes();
                  System.out.println("Description : " + ((Node) descriptionNL.item(0)).getNodeValue());
                  NodeList variable = fstElmnt.getElementsByTagName("variable");
                  Element variableElement = (Element) variable.item(0);
                  NodeList variableNL = variableElement.getChildNodes();
                  System.out.println("Variable : " + ((Node) variableNL.item(0)).getNodeValue());
                  NodeList modification = fstElmnt.getElementsByTagName("modification");
                  Element modificationElement = (Element) modification.item(0);
                  NodeList modificationNL = modificationElement.getChildNodes();
                  System.out.println("Modification : " + ((Node) modificationNL.item(0)).getNodeValue());
              }
//}
        
    }
      


}