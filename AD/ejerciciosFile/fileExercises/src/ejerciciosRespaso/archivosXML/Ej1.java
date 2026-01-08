package ejerciciosRespaso.archivosXML;

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

public class Ej1 {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.newDocument();

            Element root=doc.createElement("alumnos");
            doc.appendChild(root);

            Element alumno=doc.createElement("alumno");
            root.appendChild(alumno);

            Element nombre= doc.createElement("nombre");
            nombre.setTextContent("Juanito");
            alumno.appendChild(nombre);

            Element nota=doc.createElement("nota");
            nota.setTextContent("7.5");
            alumno.appendChild(nota);


            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source=new DOMSource(doc);
            StreamResult result=new StreamResult(new File("clase.xml"));
            transformer.transform((source),result);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
