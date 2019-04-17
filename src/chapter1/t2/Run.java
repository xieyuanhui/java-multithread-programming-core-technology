package chapter1.t2;

public class Run {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        // 构造函数支持传入一个Runnable接口的对象
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("run finish");
    }
}
