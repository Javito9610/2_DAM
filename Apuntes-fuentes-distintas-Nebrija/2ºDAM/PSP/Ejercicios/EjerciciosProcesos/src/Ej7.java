public class Ej7 extends Thread {
    private boolean stopHilo=false;
    public void run(){
        try{
            while(!stopHilo){
                System.out.println("----En el Hilo----");
                Thread.sleep(1000);
            }
            System.out.println("--------El hilo complementario ha finalizado---------");
        }catch(InterruptedException e){
            System.out.println("SE HA PRODUCIDO UNA EXCEPCIÓN: Hilo interrumpido");
        }
    }
    public void pararHilo(){
        interrupt();
    }
    public static void main(String[] args) throws InterruptedException {
        Ej7 h = new Ej7();
        h.start();
        //h.join(); si metieramos este join dariamos priordad al hilo h cuyo while de su run se volveria un bucle infinito. Porque no continuaria su hilo main para o cambiar su variable de control a false o parar el hilo con un interrupt()
        for (int i=0;i<10000000;i++);
        System.out.println(h.toString());
        h.pararHilo();
        System.out.println("Hilos activos: "+h.activeCount());

    }
}
