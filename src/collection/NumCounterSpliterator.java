package collection;

import java.util.Spliterator;
import java.util.function.Consumer;

public class NumCounterSpliterator implements Spliterator<Character> {

    private String str;
    private int currentChar = 0;
    private boolean canSplit = true;

    public NumCounterSpliterator(String str, int currentChar, boolean canSplit) {
        this.str = str;
        this.currentChar = currentChar;
        this.canSplit = canSplit;
    }

    public void forEachRemaining(Consumer<? super Character> action) {
        do{

        } while (tryAdvance(action));
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        if (str.equals("")) {
            return false;
        }
        action.accept(str.charAt(currentChar++));
        return currentChar < str.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int i = currentChar;
        for (; canSplit && i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) {
                String str1 = str;
                this.str = str1.substring(currentChar, i);
                canSplit = false;
                if (i + 1 < str1.length()) {
                    return new NumCounterSpliterator(str1.substring(i + 1, str1.length()), 0, true);
                }
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return str.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}
