public class Ej8 extends Thread {
    Ej8(String nombre) {
        this.setName(nombre);
    } // Es un constructor para que se le pueda asociar un nombre a los hilos (renombrarlos) y tomarlo con getName(). Ya que aunque herede de thread, la clase Ej8, por sí sola, sin constructor, no puede actuar como un thread, pudiendo renombrar a sus nuevos hilos creados.
    @Override
    public void run(){
        System.out.println("Ejecutando el hilo: "+getName());
        for (int i=1; i<=5;i++){
            System.out.println(getName()+": "+i);
        }
    }
    public static void main(String[] args){
        Ej8 hilo1 = new Ej8("Hilo1");
        Ej8 hilo2 = new Ej8("Hilo2");
        Ej8 hilo3 = new Ej8("Hilo3");
        Ej8 hilo4 = new Ej8("Hilo4");
        Ej8 hilo5 = new Ej8("Hilo5");
        hilo1.setPriority(MIN_PRIORITY);
        hilo2.setPriority(7);
        hilo3.setPriority(3);
        hilo4.setPriority(NORM_PRIORITY);
        hilo5.setPriority(MAX_PRIORITY);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
    }
}
