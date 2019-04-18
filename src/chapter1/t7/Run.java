package chapter1.t7;

/**
 * 测试线程是否处于活动状态
 * 活动状态：线程处于正在运行或者准备开始运行的状态
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin == " + myThread.isAlive());
        myThread.start();
        Thread.sleep(1000);
        System.out.println("end == " + myThread.isAlive());
    }
}
