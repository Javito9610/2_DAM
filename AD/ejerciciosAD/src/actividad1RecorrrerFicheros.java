import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class actividad1RecorrrerFicheros {

    public static void main(String[] args) {
        boolean terminarPrograma=false;
        Scanner sc = new Scanner(System.in);
        File carpetaActual = new File("D:\\PMyDM");
        while(!terminarPrograma) {
            System.out.println("Estás en el gestor de archivos de:" + carpetaActual.getAbsolutePath() + "\n");
            System.out.println("----------------------------Te mostraremos los elementos de este fichero---------------------------");
            recorrerFicheros(carpetaActual);
            File nuevaCarpeta=menu(carpetaActual,sc);
            if(nuevaCarpeta==null) {
                terminarPrograma=true;
            }else {carpetaActual=nuevaCarpeta;}
        }
        sc.close();
        System.out.println("Programa finalizado");
    }

    static void recorrerFicheros(File carpetaActual) {
        if (!carpetaActual.isDirectory()||!carpetaActual.exists()||carpetaActual==null) {
            System.out.println("No es un directorio valido...");
            return;
        }
        File[] elementos = carpetaActual.listFiles();
        if(elementos==null||elementos.length==0) {
            System.out.println("La carpeta esta vacía");
            return;
        }
        for (int i = 0; i<elementos.length; i++) {
            System.out.println((i+1)+" - "+elementos[i].getName()+(elementos[i].isDirectory()?"[DIR]":"   "));
        }

    }

    static  File menu(File carpetaActual, Scanner sc){
        if(!carpetaActual.isDirectory()){
            entrada(carpetaActual,sc);
        }

        boolean valorCorrecto=false;
        while(!valorCorrecto) {
            System.out.println("---------¿Qué operación quieres realizar?-----(Elígelo mediante los números de los índices)-----");
            System.out.println("1.Entrar en fichero/carpeta.");
            System.out.println("2.Crear un fichero/carpeta.");
            System.out.println("3.Borrar un fichero/carpeta.");
            System.out.println("4.Modificar/editar fichero (Solo para ficheros)");
            System.out.println("5.Atrás");
            System.out.println("6.Salir del sistema");
            System.out.println("Elige una opción.");
            String opcion = sc.nextLine().trim();
            try {
                int opcionNumerico = Integer.parseInt(opcion);
                switch (opcionNumerico) {
                    case 1:
                        carpetaActual=entrada(carpetaActual, sc);
                        valorCorrecto = true;
                        break;
                    case 2:
                        crearElemento(carpetaActual, sc);
                        valorCorrecto = true;
                        break;
                    case 3:
                        borrarElemento(carpetaActual, sc);
                        valorCorrecto = true;
                        break;
                    case 4:
                        modificarElemento(carpetaActual, sc);
                        valorCorrecto = true;
                        break;
                    case 5:
                        carpetaActual=volverACarpetaAnterior(carpetaActual);
                        valorCorrecto = true;
                        break;
                    case 6:
                        valorCorrecto = true;
                        return null;
                    default:
                        System.out.println("Valor incorrecto.Vuelve a intentarlo.");
                }
            }catch (NumberFormatException e){
                System.out.println("Valor incorrecto.Vuelve a intentarlo.");
            }
        }

       return carpetaActual;
    }

    static File entrada(File carpetaActual,Scanner sc){
        File[] elementos = carpetaActual.listFiles();
        if (elementos == null || elementos.length == 0){
            System.out.println("No hay elementos aquí.");
            return carpetaActual;
        }
        boolean valorCorrecto=false;
        while(!valorCorrecto) {
            System.out.println("Seleciona el número del elemento en el que deseas entrar.");
            String numElemento = sc.nextLine().trim();

            try {
                int numElementoInt = Integer.parseInt(numElemento);
                if (numElementoInt<1 || numElementoInt > elementos.length){
                    System.out.println("Te has equivocado, ese elemento no existe. Inténtalo de nuevo...");
                    continue;
                }
                File elegido=elementos[numElementoInt-1];
                if (elegido.isFile()){
                    try(Scanner lector=new Scanner(elegido)){
                        System.out.println("El el contenido del archivo: "+elegido.getName()+" :");
                        while(lector.hasNextLine()){
                            System.out.println(lector.nextLine());
                        }
                    } catch (Exception e) {
                        System.out.println("Error al leer el archivo");
                    }
                    valorCorrecto=true;
                    return carpetaActual;
                } else if (elegido.isDirectory()) {
                    carpetaActual=elegido;
                    valorCorrecto=true;
                    return carpetaActual;
                }


            }catch (NumberFormatException e){
                System.out.println("Valor incorrecto.Vuelve a intentarlo.");
            }
        }
    return carpetaActual;
    }

    static void crearElemento (File carpetaActual,Scanner sc){
        System.out.println("¿Que quieres crear, un fichero o un directorio (F/D)?");
        String tipo = sc.nextLine().trim().toUpperCase();
        System.out.println("Introduce el nombre del nuevo "+ (tipo.equals("F")? "fichero":"directorio"));
        String nombre = sc.nextLine().trim();
        File nuevoElemento= new File(carpetaActual,nombre);
        try{
            if(tipo.equals("F")){
                if(nuevoElemento.createNewFile()){
                    System.out.println("Fichero "+nombre+" guardado con éxito.");
                }else{
                    System.out.println("Fichero "+nombre+" no se puede guardar. Es posible que ya exista.");
                }
            }
            else if (tipo.equals("D")) {
                if(nuevoElemento.mkdir()){
                    System.out.println("Directorio "+nombre+" creado correctamente.");
                }else{
                    System.out.println("Directorio "+nombre+" no se puede crear. Es posible que ya exista.");
                }
            }
        }catch (Exception e){
            System.out.println("Error al crear el fichero o un directorio"+e.getMessage());
        }
    }

    static void borrarElemento (File carpetaActual,Scanner sc){
        File[] elementos = carpetaActual.listFiles();
        if (elementos == null || elementos.length == 0){
            System.out.println("No hay elementos para borrar en esta carpeta. Está vacía");
            return;
        }
        System.out.println("Selecciona el número del elemento que quieres borrar.");
        String numElemento = sc.nextLine().trim();
        try {
            int numElementoInt = Integer.parseInt(numElemento);
            if (numElementoInt<1 || numElementoInt > elementos.length){
                System.out.println("Te has equivocado, ese elemento no existe.");
                return;
            }
            File elegido=elementos[numElementoInt-1];
            if (elegido.isFile()){
                if(elegido.delete()){
                    System.out.println("El fichero "+elegido.getName()+" borrado correctamente.");
                }else{
                    System.out.println("No se pudo eliminar archivo");
                }
            } else if (elegido.isDirectory()) {
                if(elegido.delete()){
                    System.out.println("Directorio "+elegido.getName()+" borrado correctamente.");
                }else {
                    System.out.println("No se pudo eliminar directorio");
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Valor incorrecto.Vuelve a intentarlo.");
        }
    }

    static void modificarElemento (File carpetaActual,Scanner sc){
        File[] elementos = carpetaActual.listFiles();
        if (elementos == null || elementos.length == 0){
            System.out.println("No hay elementos para modificar.");
            return;
        }
        System.out.println("¿Qué fichero quieres modificar? Señálalo numéricamente");
        String numElemento = sc.nextLine().trim();
        try {
            int numElementoInt = Integer.parseInt(numElemento);
            if (numElementoInt<1 || numElementoInt > elementos.length){
                System.out.println("Te has equivocado, ese elemento no existe.");
                return;
            }
            File elegido=elementos[numElementoInt-1];
            System.out.println("Introduce el nuevo contenido:");
            String contenido = sc.nextLine();
            try(FileWriter fw=new FileWriter(elegido, false)){
                fw.write(contenido+ System.lineSeparator());
                System.out.println("Archivo modificado correctamente.");
            }catch (Exception e){
                System.out.println("Error al modificar el archivo");
            }
        }catch (NumberFormatException e){
            System.out.println("Valor incorrecto.Vuelve a intentarlo.");
        }
    }

    static File volverACarpetaAnterior(File carpetaActual) {
        File carpetaPadre = carpetaActual.getParentFile();
        if (carpetaPadre != null && carpetaPadre.exists()) {
            System.out.println("Volviendo a la carpeta: " + carpetaPadre.getName());
            return carpetaPadre;
        } else {
            System.out.println("Ya estás en la carpeta raíz, no se puede retroceder más.");
            return carpetaActual;
        }
    }
}
