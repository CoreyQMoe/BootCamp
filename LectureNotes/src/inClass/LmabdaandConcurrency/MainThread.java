package inClass.LmabdaandConcurrency;

import jdk.jfr.internal.tool.Main;

public class MainThread extends Thread{
    public void run() {
        System.out.println("Before");
        try {
            Thread.sleep(Long.MAX_VALUE);
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("After");
    }

    public static void main(String[] args) throws InterruptedException{
        Thread test = new Thread(new MainThread(), "test");
        test.start();
        //test.interrupt();
        test.join();
        System.out.println("testThread has Finished");
    }
}
