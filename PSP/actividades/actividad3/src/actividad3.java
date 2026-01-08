import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class actividad3 {

    static class hiloCliente extends Thread{

        private Socket cliente;
        public hiloCliente(Socket cliente){
            this.cliente = cliente;
        }
        public void run(){
            try {
                PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
                out.println("Hola soy tu mini servidor");
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)throws IOException {
        ServerSocket servidor = new ServerSocket(8080);
        System.out.println("Servidor Iniciado");
        while(true){
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado");
            hiloCliente hilo = new hiloCliente(cliente);
            hilo.start();
        }

    }


}
