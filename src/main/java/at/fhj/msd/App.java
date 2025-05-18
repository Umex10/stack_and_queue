package at.fhj.msd;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MyQueueArray<Integer> mqa = new MyQueueArray<>(5, Integer.class);
        mqa.put(1);
        System.out.println(mqa.size());
        System.out.println(mqa.get());
        mqa.put(1);
        mqa.put(2);
        mqa.put(3);
        mqa.put(4);
        mqa.put(5);
        System.out.println(mqa.size());
        mqa.put(6);
    }
}
