import java.io.IOException;
import java.io.InputStream;

public class Ej2 {
    static void main() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "\"D:\\saludo.txt\"");
        Process p= pb.start();
        InputStream iS=p.getInputStream();
        int c=0;
        while((c=iS.read())!=-1){
            System.out.print((char)c);
        }
    }
}
