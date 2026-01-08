package ejerciciosRespaso.archivosXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

public class Ej3 {
    public static void main(String args[]){
       try {
           DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
           DocumentBuilder db= dbf.newDocumentBuilder();
           Document doc=db.parse("clase.xml");

           NodeList listaAlumnosNotas=doc.getElementsByTagName("alumno");

           for(int i=0; i<listaAlumnosNotas.getLength();i++){

               System.out.println("Nombre: "+((Element) listaAlumnosNotas.item(i)).getElementsByTagName("nombre").item(0).getTextContent()+" "+"Nota: "+((Element) listaAlumnosNotas.item(i)).getElementsByTagName("nota").item(0).getTextContent());
           }


       }catch (Exception e){
           System.out.println(e.getMessage());
       }
    }
}
