public class Ej5 extends Thread {
    public void run(){
        System.out.println("Informacion de hilo: "+Thread.currentThread().toString());
        for(int i=0; i<10000;i++){
            i++;
        }
        System.out.println(Thread.currentThread().getName()+" ha finalizado");
    }
    public static void main(String[] args) {
        System.out.println("----Informacion del hilo principal 'main'----");
        System.out.println();
        Thread.currentThread().setName("principal");
        System.out.println("Dentro del hilo: "+ Thread.currentThread().getName()+"INFO: "+Thread.currentThread().toString());

        ThreadGroup grupo= new ThreadGroup("grupo_de_hilos");
        Ej5 h = new Ej5();

        Thread h1 = new Thread(grupo,h,"hilo1");
        Thread h2 = new Thread(grupo,h,"hilo2");
        Thread h3 = new Thread(grupo,h,"hilo3");

        h1.start();
        h2.start();
        h3.start();

        System.out.println("Hilos activos: "+h.activeCount());




    }
    
}
