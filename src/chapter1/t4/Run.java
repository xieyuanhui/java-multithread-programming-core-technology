package chapter1.t4;

public class Run {
    public static void main(String[] args) {
        // 这里是针对一个对象的属性，所以是共享的
        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");
        // 注释代码是针对不同对象的，所以数据是不共享的
//        MyThread a = new MyThread("A");
//        MyThread b = new MyThread("B");
//        MyThread c = new MyThread("C");
//        MyThread d = new MyThread("D");
//        MyThread e = new MyThread("E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
