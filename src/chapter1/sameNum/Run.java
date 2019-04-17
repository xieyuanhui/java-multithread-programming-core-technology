package chapter1.sameNum;

public class Run {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread a = new Thread(thread);
        Thread b = new Thread(thread);
        Thread c = new Thread(thread);
        Thread d = new Thread(thread);
        Thread e = new Thread(thread);
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
