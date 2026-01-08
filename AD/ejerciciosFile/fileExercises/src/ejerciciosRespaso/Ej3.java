package ejerciciosRespaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("¡Vamos a mostrar el contenido de un archivo!");
        System.out.println("Introduce la ruta del archivo que quiere leer (por favor evita utilizar comillas al inicio y final):");
        String ruta=scanner.nextLine().trim();
        File file=new File(ruta);
        System.out.println("Ruta introducida: " + file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        byte[] buffer=new byte[1024];
        int numeroBytes;
        try(FileInputStream fis=new FileInputStream(file)){
            while((numeroBytes=fis.read(buffer))!=-1){
                System.out.println(new String(buffer,0,numeroBytes));
            }
            System.out.println("numeroBytes = "+numeroBytes);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
