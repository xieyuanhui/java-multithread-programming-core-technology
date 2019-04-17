package chapter1.t4;

/**
 * 共享数据的情况
 */
public class MyThread extends Thread {
    private int count = 5;

//    public MyThread(String name) {
//        this.setName(name);
//    }

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算。count = " + count);
    }
}
