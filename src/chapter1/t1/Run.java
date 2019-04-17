package chapter1.t1;

public class Run {
    /**
     * 代码执行结果与代码顺序无关
     * @param args
     */
    public static void main(String[] args) {
        MyThread myTread = new MyThread();
        myTread.start();
        System.out.println("run finish!");
    }
}
