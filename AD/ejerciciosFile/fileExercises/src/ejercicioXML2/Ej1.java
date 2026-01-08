package ejercicioXML2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Ej1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder db= dbf.newDocumentBuilder();
            Document doc= db.newDocument();

            Element root=doc.createElement("cursos");
            doc.appendChild(root);

            Element curso=doc.createElement("curso");
            curso.setAttribute("id","1");
            root.appendChild(curso);

            Element nombre=doc.createElement("nombre");
            nombre.setTextContent("Java");
            curso.appendChild(nombre);

            Element horas=doc.createElement("horas");
            horas.setTextContent("40");
            curso.appendChild(horas);
            //-----------------------------------------------------------
            Element curso2=doc.createElement("curso");
            curso2.setAttribute("id","2");
            root.appendChild(curso2);

            Element nombre2=doc.createElement("nombre");
            nombre2.setTextContent("Python");
            curso2.appendChild(nombre2);

            Element hora2=doc.createElement("horas");
            hora2.setTextContent("50");
            curso2.appendChild(hora2);

            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("asignaturas.xml"));
            transformer.transform(source, result);


        }catch(Exception e){
            System.out.println(("Error: "+e.getMessage()));
        }
    }
}
