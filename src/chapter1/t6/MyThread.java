package chapter1.t6;

/**
 * 构造函数会被main线程调用，run方法会被Thread-0调用，是自动调用的方法
 */
public class MyThread extends Thread {

    public MyThread() {
        System.out.println("构造方法的打印：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法的打印：" + Thread.currentThread().getName());
    }
}
