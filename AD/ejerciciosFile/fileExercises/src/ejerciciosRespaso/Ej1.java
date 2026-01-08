package ejerciciosRespaso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Introduce la ruta y el nombre de tu carpeta para comprobar si existe:");
        Scanner scanner = new Scanner(System.in);
        try {
            String nombre = scanner.next().trim();
            File file = new File(nombre);
            if (!file.exists() || !file.isDirectory()) {
                System.out.println("La ruta hacia la carpeta o la carpeta no existe");
                System.out.println("-------------Creando la carpeta-------------");
                System.out.println("La carpeta se creo satisfactoriamente");
                file.mkdir();
            }else {
                System.out.println("Esta carpeta ya existe.");
            }
        }catch(Exception e){
            System.out.println("Ha habido un problema con la búsqueda");
        }
    }
}
