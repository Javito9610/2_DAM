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

public class Ej3 {
    public static void main(String[] args) {
        try{
            File archivo=new File("E:\\DAMAsignaturas\\2_DAM\\AD\\ejerciciosFile\\notas.xml");

            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            //Esto es para poder editar un archivo xml existente.
            //señalas el archivo que quieres editar con el file. Lo metes en la variable doc con Document, utilizando el .parse() para indicar que trabajaremos sobre ese documento
            Document doc=db.parse(archivo);
            //mediante la line de código de abajo conseguimos indicar que vamos a editar el archivo xml mediante. normalize()
            doc.getDocumentElement().normalize();

            Element nuevo=doc.createElement("alumno");
            nuevo.setAttribute("id","6");

            Element nombre= doc.createElement("nombre");
            nombre.setTextContent("Pedro");
            nuevo.appendChild(nombre);

            Element nota= doc.createElement("nota");
            nota.setTextContent("7.15");
            nuevo.appendChild(nota);

            doc.getDocumentElement().appendChild(nuevo);

            TransformerFactory tf=TransformerFactory.newInstance();
            Transformer transformer=tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source= new DOMSource(doc);
            StreamResult result= new StreamResult(archivo);
            transformer.transform(source,result);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
