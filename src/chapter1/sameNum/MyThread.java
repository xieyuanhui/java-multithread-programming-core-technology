package chapter1.sameNum;

/**
 * println()方法是同步的，但是i--是在进入方法之前发生的，所以还是存在线程安全的问题
 */
public class MyThread extends Thread {

    private int i = 5;

    @Override
    public void run() {
        System.out.println("i = " + (i--) + " thread name = " + this.currentThread().getName());
    }
}
