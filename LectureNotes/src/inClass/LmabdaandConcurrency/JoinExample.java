package inClass.LmabdaandConcurrency;

import java.util.Random;

public class JoinExample implements Runnable{
    private Random rand = new Random(System.currentTimeMillis());
    private static int counter = 0;
    public void run() {
//        for(int i = 0; i < 100000000; i++) {
//            rand.nextInt();
//        }
//        System.out.println("["+Thread.currentThread().getName()+"] finished.");
        while (counter < 10) {
            System.out.println("[" + Thread.currentThread().getName() + " ] before: " + counter);
            counter++;
            System.out.println("[" + Thread.currentThread().getName() + " ] after: " + counter);
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
            threads[i] = new Thread(new JoinExample(), "thread-" + i);
            threads[i].start();
        }
    }
}
