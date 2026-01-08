import java.io.IOException;

public class Ej1 {
    static void main() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
        Process p=pb.start();
    }
}
