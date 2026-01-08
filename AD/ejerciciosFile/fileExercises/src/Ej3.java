import java.io.FileInputStream;   // Para leer bytes del archivo original
import java.io.FileOutputStream;  // Para escribir bytes en el archivo de destino
import java.io.IOException;       // Para manejar errores de entrada/salida
import java.util.Scanner;         // Para leer datos del usuario

public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1️⃣ Pedimos la ruta del archivo original
        System.out.print("Ingresa la ruta del archivo original: ");
        String rutaOriginal = scanner.nextLine();

        // 2️⃣ Pedimos la ruta donde queremos guardar la copia
        System.out.print("Ingresa la ruta del archivo de destino: ");
        String rutaCopia = scanner.nextLine();

        // 3️⃣ Creamos un buffer de 1024 bytes (1 KB)
        byte[] buffer = new byte[1024];

        /*
         4️⃣ Abrimos los archivos con try-with-resources
         - FileInputStream fis → para leer bytes del archivo original
         - FileOutputStream fos → para escribir bytes en el archivo de destino
         */
        try (FileInputStream fis = new FileInputStream(rutaOriginal);
             FileOutputStream fos = new FileOutputStream(rutaCopia)) {

            int bytesLeidos; // Variable para guardar cuántos bytes leemos en cada bloque

            // 5️⃣ Mientras haya bytes por leer
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                /*
                 fis.read(buffer) → Lee hasta buffer.length bytes del archivo original
                 Devuelve la cantidad de bytes leídos o -1 si llegamos al final del archivo
                */

                /*
                 fos.write(buffer, 0, bytesLeidos) → Escribe los bytes leídos en el archivo destino
                 Importante:
                 - buffer tiene 1024 posiciones
                 - Si la última lectura tiene menos de 1024 bytes, no queremos escribir basura
                 - Por eso usamos "0" como inicio y "bytesLeidos" como cantidad
                */
                fos.write(buffer, 0, bytesLeidos);
            }

            System.out.println("Archivo copiado con éxito!");

        } catch (IOException e) {
            // Si algo falla (archivo no encontrado, permisos, etc.)
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}
