package chapter1.t12;

/**
 * 判断线程是否停止
 */
public class Run {

    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.sleep(1000);
            myThread.interrupt();
            System.out.println("是否停止1 ？ = " + myThread.isInterrupted());
            System.out.println("是否停止2 ？ = " + myThread.isInterrupted());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
