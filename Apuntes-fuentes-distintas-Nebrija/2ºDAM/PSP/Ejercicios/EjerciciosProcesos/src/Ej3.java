import java.io.IOException;
import java.util.Arrays;

public class Ej3 {
    public static void main(String[] args) {
        if(args.length<=0){
            System.out.println("Debe ingresar comando a ejecutar");
            System.exit(1);
        }
        ProcessBuilder pb = new ProcessBuilder(args);
        pb.inheritIO();
        try{
            Process p=pb.start();
            int codRet=p.waitFor();
            System.out.println();
            System.out.println("La ejecución de "+ Arrays.toString(args)+" devuelve: "+ codRet+" "+ (codRet==0?"EJECUCIÓN CORRECTA": "ERROR"));
        }catch(IOException e){
            System.out.println("Error durante la ejecución del proceso");
            e.printStackTrace();
            System.exit(2);
        }catch (InterruptedException e){
            System.out.println("Programa interrumpido");
            e.printStackTrace();
            System.exit(3);
        }
    }
}
