public class Ej9 {
    //Ejercicio de compartición de recursos.
    static  class  Contador{
        private int valor=0;
        public synchronized void incrementar() {
            valor++;
            if(valor==10){
                notifyAll();
            }
        }
        public synchronized int getValor() {
            return valor;
        }

        public synchronized void esperarHastaDiez() {
            while(valor<10){
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

    }
    static  class  Observador extends Thread{
        Contador cont;
        public Observador(Contador cont){
            this.cont=cont;
        }
        @Override
        public void run() {
            System.out.println("Observador preparado. Listo para el trabajo cuando lleguemos a 10");
            cont.esperarHastaDiez();
            System.out.println("Observador ejecutandose, porque incrementador ya calculó");
            for(int i=0;i<10;i++){
                try {
                    System.out.println("--------------------");
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }

            }
            System.out.println("El observador detectó: "+cont.getValor());
        }
    }
    static  class  Incrementador extends Thread{
        Contador cont;
        public Incrementador(Contador cont){
            this.cont=cont;
        }
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                cont.incrementar();
            }

        }

    }
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        Observador obs=new Observador(contador);
        Incrementador inc=new Incrementador(contador);
        obs.start();
        inc.start();
        inc.join();
        obs.join();
        System.out.println("El valor del contador es: "+contador.getValor());
    }
}
