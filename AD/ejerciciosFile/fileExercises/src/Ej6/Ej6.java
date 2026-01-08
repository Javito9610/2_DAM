package Ej6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ej6 {
    public static void main(String[] args) throws IOException {
        String rutaArchivo = "E://DAMAsignaturas//2_DAM//AD//ejerciciosFile//fileExercises//src//Ej6//personas.dat";
        Persona persona1 = new Persona("Javi", 29);
        Persona persona2 = new Persona("Maria", 30);
        Persona persona3 = new Persona("Jorge", 31);
        Persona persona4 = new Persona("Alfredo", 32);
        Persona[] personas = new Persona[]{persona1, persona2, persona3, persona4};

        try (FileOutputStream fos = new FileOutputStream(rutaArchivo);
             ObjectOutputStream oos= new ObjectOutputStream(fos);) {
            int iteraciones=0;
            while((iteraciones)<personas.length){
                oos.writeObject(personas[iteraciones]);
                iteraciones++;
            }
            oos.close();
            System.out.println("Se han copiado los objetos en el archivo satisfactoriamente.");
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado"+e.getMessage());
        }catch (IOException e) {
            System.out.println("Error en la gestión del archivo"+ e.getMessage());
        }
    }
}
