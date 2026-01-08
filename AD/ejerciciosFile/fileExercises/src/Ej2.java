import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej2 {
    static void main() {
        //Ejercicio 2 – Leer un archivo línea por línea
        String ruta = "D:/saludo.txt";
        FileReader fr=null;
        BufferedReader br=null;


        try{
            // Primero con filereader
            long cronometroInicio = System.currentTimeMillis();

           fr=new FileReader(ruta);
           int c;
           while((c=fr.read())!=-1){
               System.out.print((char) c);
            }

            long cronometroFin = System.currentTimeMillis();

            System.out.println("\n");
            System.out.println("Ha tardado en leerlo con FileReader: "+(cronometroFin-cronometroInicio)+" milisegundos");
            System.out.println("\n");

            //ahora con bufferedreader
            cronometroInicio = System.currentTimeMillis();
            br=new BufferedReader(new FileReader(ruta)); // dentro del buffered reader va siempre un filereader porque el buffered es como la via o el canal por el que lee
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
            cronometroFin = System.currentTimeMillis();
            System.out.println("\n");
            System.out.println("Ha tardado en leerlo con BufferedReader: "+ (cronometroFin-cronometroInicio)+" milisegundos");
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
        }
    }
}
