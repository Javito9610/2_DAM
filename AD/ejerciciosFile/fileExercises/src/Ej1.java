import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class Ej1 {


        static void main() {
//Ejercicio 1 – Crear un archivo de texto simple

            System.out.println("Ejercicio 1 vamos a crear un archivo y a pintar en el");
            Scanner sc = new Scanner(System.in);
            try{
                File saludo= new File("D:/saludo.txt");
                if(saludo.createNewFile()){
                    System.out.println("Archivo creado con exito");
                }else{
                    System.out.println("El archivo no se ha creado porque ya existe");
                }
                System.out.println("Vamos a pintar en el archivo");
                FileWriter fw = new FileWriter("D:/saludo.txt",true);
                String texto = sc.nextLine();
                fw.write(texto);
                fw.close();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Error al crear el archivo");
            }
        }
}
