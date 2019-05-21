package chapter1.t13forprint;

/**
 * for语句下面的语句还是会继续运行
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
        System.out.println("if you see me, it means thread is running!");
    }
}
