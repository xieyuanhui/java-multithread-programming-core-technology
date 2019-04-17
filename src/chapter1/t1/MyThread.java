package chapter1.t1;

/**
 * 方式一：继承Thread类
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
