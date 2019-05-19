package demo;

public class SyncBlockAndMethod {

    public void syncsTask() {
        synchronized (this) {
            System.out.println("Hello");
        }
    }

    public synchronized void syncTask() {
        System.out.println("Hello Again");
    }
}
