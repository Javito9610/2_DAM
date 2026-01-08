package ejerciciosRespaso.archivosXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Ej2 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder db= dbf.newDocumentBuilder();
        Document document = db.parse("clase.xml");
        document.getDocumentElement().normalize();

        Element alumno=document.createElement("alumno");

        Element nombre=document.createElement("nombre");
        alumno.setTextContent("Javitoo");
        alumno.appendChild(nombre);

        Element nota= document.createElement("nota");
        nota.setTextContent("9.75");
        alumno.appendChild(nota);

        document.getDocumentElement().appendChild(alumno);

        TransformerFactory tf=TransformerFactory.newInstance();
        Transformer transformer= tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source= new DOMSource(document);
        StreamResult result= new StreamResult("clase.xml");
        transformer.transform(source,result);
    }
}
