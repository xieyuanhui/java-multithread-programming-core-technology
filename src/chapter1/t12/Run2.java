package chapter1.t12;

public class Run2 {

    /**
     * 方法interrupted()具有清除状态的功能
     * @param args
     */
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？= " + Thread.interrupted());
        System.out.println("是否停止2？= " + Thread.interrupted());
        System.out.println("end!");
    }
}
