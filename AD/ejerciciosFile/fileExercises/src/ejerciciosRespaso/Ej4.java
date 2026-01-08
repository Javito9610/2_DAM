package ejerciciosRespaso;

import java.io.*;
import java.util.Scanner;

public class Ej4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Vamos a escribir o a añadir lineas a un archivo!");
        System.out.println("Dime la ruta al archivo en el que quieres entrar:");
        String rutaArchivo= scanner.nextLine().trim();
        File file = new File(rutaArchivo);
        if(!file.exists()){
            System.out.println("El archivo no existe");
            return;
        }
        try(FileWriter fw=new FileWriter(file,true);
            BufferedWriter bw=new BufferedWriter(fw)){
            System.out.println("Iniciando el archivo. Escribe lo que quieras y cuando quieras terminar escribe 'FIN' (en mayúsculas):");
            String linea;
            while(!(linea = scanner.nextLine()).equalsIgnoreCase("FIN")){
                bw.write(linea);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

    }
}
