package ejercicioXML2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;

public class Ej3 {
    public static void main(String[] args) {
        try{

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("E:/DAMAsignaturas/2_DAM/AD/ejerciciosFile/asignaturas.xml");
            document.getDocumentElement().normalize();

            Element nuevo=document.createElement("curso");
            nuevo.setAttribute("id","3");


            Element nombre=document.createElement("nombre");
            nombre.setTextContent("JavaScript");
            nuevo.appendChild(nombre);

            Element horas=document.createElement("horas");
            horas.setTextContent("30");
            nuevo.appendChild(horas);

            document.getDocumentElement().appendChild(nuevo);
            TransformerFactory tf= TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source= new DOMSource(document);
            StreamResult result= new StreamResult("E:/DAMAsignaturas/2_DAM/AD/ejerciciosFile/asignaturas.xml");
            transformer.transform(source,result);


        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
