package ejerciciosXML;

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
            String[][]alumnos={{"1","Alfredo","10"},{"2","Jorge","9.5"},{"3","Jose","9.75"}};
            //Creamos el DOM sobre ell que vamos a pintar el XMl
            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.newDocument();

            //generamos la estructura "elementos"

            Element root=doc.createElement("Alumnos");
            doc.appendChild(root);

            for(String[]alum:alumnos) {

                Element alumno = doc.createElement("alumno");
                alumno.setAttribute("id", alum[0]);
                root.appendChild(alumno);

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(alum[1]);
                alumno.appendChild(nombre);

                Element nota = doc.createElement("nota");
                nota.setTextContent(alum[2]);
                alumno.appendChild(nota);
            }
            TransformerFactory tf= TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source=new DOMSource(doc);
            StreamResult result=new StreamResult(new File("notas.xml"));
            transformer.transform(source,result);



        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
