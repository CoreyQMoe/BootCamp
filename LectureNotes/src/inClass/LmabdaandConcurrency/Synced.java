package inClass.LmabdaandConcurrency;

public class Synced implements Runnable{
    private static int counter = 0;

    public void run() {
        while(counter < 10) {
            synchronized (Synced.class) {
                System.out.println("["+Thread.currentThread().getName()+"] before:" + counter);
                counter++;
                System.out.println("["+Thread.currentThread().getName()+"] after:" + counter);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads = new Thread[5];
//        for(int i = 0; i < threads.length; i++) {
//            threads[i] = new Thread(new JoinExample(), "joinThread-" + i);
//            threads[i].start();
//        }
//        for(int i = 0; i < threads.length; i++) {
//            threads[i].join();
//        }
//        System.out.println("[" + Thread.currentThread().getName()+"] All threads have finished");

        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Synced(), "thread-" + i);
            threads[i].start();
        }
    }
}
