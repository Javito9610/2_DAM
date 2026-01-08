package ejercicioXML2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Ej4 {
    public static void main(String[] args) {
        try {
            File file=new File("asignaturas.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc= db.parse(file);
            NodeList cursos=doc.getElementsByTagName("curso");
            for(int i=0;i<cursos.getLength();i++){
                Element curso=(Element)cursos.item(i);
                if(curso.getAttribute("id").equals("1")){
                    curso.getElementsByTagName("horas").item(0).setTextContent("60");
                }

            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("asignaturas.xml"));

            transformer.transform(source, result);

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
