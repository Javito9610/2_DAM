public class actividad2 {

    static int contador;

    static class miHilo extends Thread{

        public void run(){
            for(int i=0;i<100000000;i++){
                // contador++ con tan solo esto generaría condición de carrera y para solucionarlo utilizamos synchronized
                synchronized (actividad2.class){
                    contador++;
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        miHilo hilo1 = new miHilo();
        miHilo hilo2 = new miHilo();
        miHilo hilo3 = new miHilo();

        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("El valor del contador es: " + contador);

    }

}
