package Ej6;

import java.io.*;
import java.util.ArrayList;

public class Ej7 {
    public static void main(String[] args) throws IOException {
        String archivo="E://DAMAsignaturas//2_DAM//AD//ejerciciosFile//fileExercises//src//Ej6//personas.dat";
        ArrayList<Persona> personas=new ArrayList<Persona>();
        ArrayList<String>personasAuxiliar=new ArrayList<String>();
        try(FileInputStream fis=new FileInputStream(archivo);
            ObjectInputStream ois=new ObjectInputStream(fis);){
            while(true){
                try {
                    Persona persona = (Persona) ois.readObject();
                    personas.add(persona);
                }catch (Exception e){
                    break;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(personas);
        }
    }
}
