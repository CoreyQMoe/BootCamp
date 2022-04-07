package inClass.LmabdaandConcurrency;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }
        @Override
        public void run() {
            System.out.println("Executing thread: " + Thread.currentThread().getName());
        }

    public static void main(String[] args) throws InterruptedException{
        MyThread mythread = new MyThread("myThread");
        mythread.start();
    }

}
