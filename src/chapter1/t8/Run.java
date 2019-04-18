package chapter1.t8;

/**
 * sleep()方法
 */
public class Run {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin = " + System.currentTimeMillis());
//        myThread.run();  //睡眠两秒
        myThread.start();  //
        System.out.println("end = " + System.currentTimeMillis());
    }
}
