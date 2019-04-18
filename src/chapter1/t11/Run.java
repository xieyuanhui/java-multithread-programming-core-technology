package chapter1.t11;

/**
 * interrupt()方法仅仅是在当前线程中打了一个停止得标记，并不是真的停止线程
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(2000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
