package chapter1.random_thread;

public class Test {

    public static void main(String[] args) {
        try {
            MyThread myTread = new MyThread();
            myTread.setName("myThread");
            myTread.start();
            for (int i = 0; i < 10; i++) {
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
