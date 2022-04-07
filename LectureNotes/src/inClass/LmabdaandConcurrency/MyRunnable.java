package inClass.LmabdaandConcurrency;

public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Exceuting runnalbe: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable(), "myRunnable");
        myThread.start();
    }
}

