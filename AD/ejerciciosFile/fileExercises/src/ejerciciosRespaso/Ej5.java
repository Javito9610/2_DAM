package ejerciciosRespaso;

import java.io.File;
import java.util.Scanner;

public class Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vamos a recorrer una carpeta:");
        System.out.println("Dime la ruta de la carpeta que quieres recorrer");
        String rutaCarpeta= sc.nextLine().trim();
        File file = new File(rutaCarpeta);
        if(!file.exists() || !file.isDirectory()){
            System.out.println("La carpeta no existe...BYE");
            return;
        }
        File[] files= file.listFiles();
        int c=0;
        while (c<files.length){
            System.out.println(files[c].getName()+" "+(files[c].isDirectory()?"DIR":"   ")+" "+(files[c].isFile()?files[c].length()+"KB":"   "));
            c++;
        }

    }
}
