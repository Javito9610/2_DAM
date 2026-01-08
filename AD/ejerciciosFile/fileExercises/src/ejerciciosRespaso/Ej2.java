package ejerciciosRespaso;

import java.io.File;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("¡Vamos a crear un archivo!");
        System.out.println("Introduce el nombre y la extensión del archivo que quieres crear:");
        String nombre=scanner.next().trim();
        System.out.println("Introduce ahora la ruta donde vas a querer que se aloje tu archivo, incluyendo una 'barra inclinada' al final de dicha ruta");
        String ruta=scanner.next().trim();
        try{
            File archivo=new File(ruta+nombre);
            if (!archivo.exists()) {
                archivo.createNewFile();
                System.out.println("Archivo creado con éxito");
            }else{
                System.out.println("Comprueba si el archivo ya existe en el sistema o escribiste mal la ruta");
            }

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }


    }
}
