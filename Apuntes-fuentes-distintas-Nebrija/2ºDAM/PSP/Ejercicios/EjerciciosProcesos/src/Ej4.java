public class Ej4 extends Thread{
    public void run(){
        //Esta funcion es la funcion run para ejecutar cada uno de los hilos y su informacion en cada iteracion para la creación de dichos hilos
        System.out.println("Dentro del hilo: " +Thread.currentThread().getName()
                +", Prioridad: "+Thread.currentThread().getPriority()
                +", ID: "+Thread.currentThread().getId()
                +", Hilos activos: "+Thread.currentThread().activeCount());
    }
    public static void main(String[] args) {
        //Ahora vamos con la información del hilo principal "el main"
        System.out.println("-------------INFORMACIÓN DEL HILO DE MAIN--------------");
        System.out.println();
        Thread.currentThread().setName("Principal");//le cambiamos el nombre
        System.out.println("Dentro del hilo (nombre): "+Thread.currentThread().getName()
        +", toString: "+Thread.currentThread().toString()
        +", Id: "+Thread.currentThread().getId());
        //Ahora crearemos un bucle con tres iteraciones con el cual crearemos tres hilos relacionados con la propia clase "Ej4", que es la clase donde se encuentra la funcion run lista para ejecutar el hilo que corresponda
        System.out.println();
        System.out.println("-------------AHORA VAMOS CON LOS TRES HILOS QUE CREAREMOS MEDIANTE EL METODO RUN() DE LA CLASE EJ4 QUE ES LA CREADORA DE HILOS----------");
        System.out.println();
        Thread h=null;
        for (int i=0; i<3; i++){
            h=new Ej4();
            h.setName("HILO_"+i);
            h.setPriority(i+1);
            // no existe el .setId porque JavaVM asigna un id aleatorio a cada uno
            h.start();

            System.out.println("Información del "+h.getName()+": "+h.toString());
        }
        System.out.println("3 hilos creados");
        System.out.println("Hilos activos: "+h.activeCount());

    }
}
