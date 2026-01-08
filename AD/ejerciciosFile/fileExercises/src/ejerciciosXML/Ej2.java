package ejerciciosXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Ej2 {
    public static void main(String[] args) {
        try {
            File archivo= new File("E:\\DAMAsignaturas\\2_DAM\\AD\\ejerciciosFile\\notas.xml"); //Declaramos el archivo con el que vamos a trabajar
            //Declaramos la via de transformacion del archivo xml en dom que a su vez será transformado cada objeto en distintos strings para reflejarlos en consola
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(archivo);
            //declaramos el nodo desde el que empezaremos a trabajar. El nodo raiz, con sus respectivos nodos hijos, alumno
            NodeList alumnos=doc.getElementsByTagName("alumno");
            //confeccionaremos un bloque de codigo con el cual podamos extraer en cada iteracion una entidad con sus respectivas subentidades y atributos
            for(int i=0;i<alumnos.getLength();i++){
                Element alumno=(Element) alumnos.item(i);

                String id=alumno.getAttribute("id");
                String nombre=alumno.getElementsByTagName("nombre").item(0).getTextContent();
                String nota=alumno.getElementsByTagName("nota").item(0).getTextContent();
                System.out.println("Id: "+id+" - "+"Nombre: "+nombre+" - "+"Nota: "+nota);

            }

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
