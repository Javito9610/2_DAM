public class Ej6 extends Thread {
    private boolean stopHilo=false;
    public void run(){
        while(!stopHilo){
            System.out.println("----En el Hilo----");
        }
        System.out.println("--------El hilo complementario ha finalizado---------");
    }
    public void pararHilo(){
        stopHilo=true;
    }
    public static void main(String[] args) {
        Ej6 h = new Ej6();
        h.start();
        for (int i=0;i<1000000000;i++);

        h.pararHilo();
        System.out.println("Hilos activos: "+h.activeCount());

    }
}
