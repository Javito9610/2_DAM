import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) throws IOException {
        System.out.println("Vamos a crear un directorio");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre al directorio");
        String directorio = sc.nextLine();
        System.out.println("¿En que ruta quiere crear dicho directorio?(Copie la ruta en el gestor de ficheros y péguela aqui):");
        String rutaDirectorio = sc.nextLine();
        File carpeta = new File(rutaDirectorio+"/"+directorio);
        if(carpeta.mkdirs()){
                System.out.println("Directorio guardado correctamente");
        }else {
            if(carpeta.exists()){
                System.out.println("El directorio existe");
            }else {
                System.out.println("El directorio no existe y no se ha podido crear");
                return;
            }
        }

        System.out.println("Ahora vamos a crear un archivo dentro de este directorio :"+directorio);
        System.out.println("Dime el nombre de archivo que quieres crear:");
        String archivoNombre = sc.nextLine();
        File archivo = new File(carpeta, archivoNombre);
        if(archivo.createNewFile()){
            System.out.println("Archivo guardado correctamente");
        }else  {
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
                return;
            }else{
                System.out.println("El archivo no existe y se ha podido crear");
                return;
            }
        }
    }
}
