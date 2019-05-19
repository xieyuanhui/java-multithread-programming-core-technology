package java.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public interface Spliterator<T> {
    /**
     * 处理每个元素，如果没有元素处理，则应该返回false，否则返回true
     * @param action
     * @return
     */
    boolean tryAdvance(Consumer<? super T> action);

    /**
     * 对当前线程的每个剩余元素进行指定的操作，直到所有的元素以处理或者action抛出异常
     * 抛出的异常会转发给调用者处理
     * @param action
     */
    default void forEachRemaining(Consumer<? super T> action) {
        do { } while (tryAdvance(action));
    }

    /**
     * 专门为Spliterator设计的方法，区分于普通的Iterator，该方法会把当前元素划分一部分
     * 出去创建一个新的Spliterator作为返回，两个Spliterator变为并行执行，如果元素个数
     * 小到无法划分则返回null
     * @return
     */
    Spliterator<T> trySplit();

    /**
     * 估算还剩余多少元素需要遍历
     * @return
     */
    long estimateSize();

    /**
     * 如果Spliterator有SIZED特征，就返回Spliterator里的元素数量，否则返回-1
     * @return
     */
    default long getExactSizeIfKnown() {
        return (characteristics() & SIZED) == 0 ? -1L : estimateSize();
    }

    /**
     * Spliterator及其元素的特征（具体下面会有）
     * @return
     */
    int characteristics();

    /**
     * 检查Spliterator是否包含给定的特征
     * @param characteristics
     * @return
     */
    default boolean hasCharacteristics(int characteristics) {
        return (characteristics() & characteristics) == characteristics;
    }

    /**
     * 如果Spliterator源由比较器排序（SORTED），则返回比较器
     * @return
     */
    default Comparator<? super T> getComparator() {
        throw new IllegalStateException();
    }

    /**
     * 有序的
     */
    public static final int ORDERED    = 0x00000010;

    /**
     * 唯一的
     */
    public static final int DISTINCT   = 0x00000001;

    /**
     * 已排序的
     */
    public static final int SORTED     = 0x00000004;

    /**
     * 有限大小
     */
    public static final int SIZED      = 0x00000040;

    /**
     * 非空的
     */
    public static final int NONNULL    = 0x00000100;

    /**
     * 不可变的：元素源不能进行结构修改，无法添加、替换、删除元素
     */
    public static final int IMMUTABLE  = 0x00000400;

    /**
     * 并发的：在没有外部同步的情况下由多个线程安全地同时修改元素源地特性值
     */
    public static final int CONCURRENT = 0x00001000;

    /**
     * trySplit产生的所有分隔符将同时为SIZED核SUBSIZED
     */
    public static final int SUBSIZED = 0x00004000;

    /**
     * 专门用于原始值的Spliterator
     * @param <T>
     * @param <T_CONS>
     * @param <T_SPLITR>
     */
    public interface OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>>
            extends Spliterator<T> {
        @Override
        T_SPLITR trySplit();

        @SuppressWarnings("overloads")
        boolean tryAdvance(T_CONS action);

        @SuppressWarnings("overloads")
        default void forEachRemaining(T_CONS action) {
            do { } while (tryAdvance(action));
        }
    }

    /**
     * 专门用于int值的Spliterator
     */
    public interface OfInt extends OfPrimitive<Integer, IntConsumer, OfInt> {

        @Override
        OfInt trySplit();

        @Override
        boolean tryAdvance(IntConsumer action);

        @Override
        default void forEachRemaining(IntConsumer action) {
            do { } while (tryAdvance(action));
        }

        @Override
        default boolean tryAdvance(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                return tryAdvance((IntConsumer) action);
            }
            else {
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(),
                            "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
                return tryAdvance((IntConsumer) action::accept);
            }
        }

        @Override
        default void forEachRemaining(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                forEachRemaining((IntConsumer) action);
            }
            else {
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(),
                            "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
                forEachRemaining((IntConsumer) action::accept);
            }
        }
    }

    /**
     * 专门用于Long值的Spliterator
     */
    public interface OfLong extends OfPrimitive<Long, LongConsumer, OfLong> {

        @Override
        OfLong trySplit();

        @Override
        boolean tryAdvance(LongConsumer action);

        @Override
        default void forEachRemaining(LongConsumer action) {
            do { } while (tryAdvance(action));
        }

        @Override
        default boolean tryAdvance(Consumer<? super Long> action) {
            if (action instanceof LongConsumer) {
                return tryAdvance((LongConsumer) action);
            }
            else {
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(),
                            "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
                return tryAdvance((LongConsumer) action::accept);
            }
        }

        @Override
        default void forEachRemaining(Consumer<? super Long> action) {
            if (action instanceof LongConsumer) {
                forEachRemaining((LongConsumer) action);
            }
            else {
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(),
                            "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
                forEachRemaining((LongConsumer) action::accept);
            }
        }
    }

    /**
     * 专门用于Double的Spliterator
     */
    public interface OfDouble extends OfPrimitive<Double, DoubleConsumer, OfDouble> {

        @Override
        OfDouble trySplit();

        @Override
        boolean tryAdvance(DoubleConsumer action);

        @Override
        default void forEachRemaining(DoubleConsumer action) {
            do { } while (tryAdvance(action));
        }

        @Override
        default boolean tryAdvance(Consumer<? super Double> action) {
            if (action instanceof DoubleConsumer) {
                return tryAdvance((DoubleConsumer) action);
            }
            else {
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(),
                            "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
                return tryAdvance((DoubleConsumer) action::accept);
            }
        }

        @Override
        default void forEachRemaining(Consumer<? super Double> action) {
            if (action instanceof DoubleConsumer) {
                forEachRemaining((DoubleConsumer) action);
            }
            else {
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(),
                            "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
                forEachRemaining((DoubleConsumer) action::accept);
            }
        }
    }
}

