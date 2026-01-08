package ejercicioXML2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Ej2 {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document doc=db.parse("asignaturas.xml");
            NodeList cursos=doc.getElementsByTagName("curso");
            for(int i=0; i<cursos.getLength();i++){
                Element curso=(Element) cursos.item(i);
                String id=curso.getAttribute("id");
                String nombre=curso.getElementsByTagName("nombre").item(0).getTextContent();
                String horas=curso.getElementsByTagName("horas").item(0).getTextContent();
                System.out.println("ID: "+id+" NOMBRE: "+nombre+" HORAS: "+horas);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
