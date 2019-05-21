package chapter1.t13;

/**
 * 判断线程是否停止，停止则不再执行后面的for语句
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (this.isInterrupted()) {
                System.out.println("Is stop state, go out!");
                break;
            }
            System.out.println("i = " + (i + 1));
        }
    }
}
