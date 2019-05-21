package chapter1.t12;

/**
 * isInterrupted()方法不清除中断状态，
 * 但是这里实际运行与书上不符，
 * 结合书中前面所说以实际运行为准
 */
public class Run3 {

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
