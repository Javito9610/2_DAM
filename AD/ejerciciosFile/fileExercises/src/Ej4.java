import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ej4 {
    public static void main(String[] args) {
        String archivo="D:/saludo.txt";
        byte[]buffer=new byte[1024];
        try(FileInputStream fis=new FileInputStream(archivo)) {
            int numeroBytesLeidos;
            while ((numeroBytesLeidos=fis.read(buffer))!=-1) {
                System.out.println(new String(buffer,0,numeroBytesLeidos));
                System.out.println("El numero de bytes leidos es: "+numeroBytesLeidos);
            }

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
