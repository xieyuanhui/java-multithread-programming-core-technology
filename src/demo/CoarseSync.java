package demo;

public class CoarseSync {

    static StringBuffer sb = new StringBuffer();

    public static String copyString100Times(String target) {
        int i = 0;

        while (i < 100) {
            sb.append(target);
        }
        return sb.toString();
    }
}
