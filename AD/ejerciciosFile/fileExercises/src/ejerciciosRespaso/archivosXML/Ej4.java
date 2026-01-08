package ejerciciosRespaso.archivosXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder db= dbf.newDocumentBuilder();
        Document doc=db.parse("clase.xml");
        NodeList listaAlumnos=doc.getElementsByTagName("alumno");
        for(int i=0; i<listaAlumnos.getLength();i++){
            Element alumno=(Element) listaAlumnos.item(i);
            Element nombre=(Element)alumno.getElementsByTagName("nombre").item(0);
            Element nota=(Element)alumno.getElementsByTagName("nota").item(0);
            if(nombre.getTextContent().equalsIgnoreCase("Juanito")){
                nota.setTextContent("8,95");
            }
        }
        TransformerFactory tf= TransformerFactory.newInstance();
        Transformer transformer=tf.newTransformer();
        DOMSource source=new DOMSource(doc);
        StreamResult result=new StreamResult(new File("clase.xml"));
        transformer.transform(source,result);
    }
}
