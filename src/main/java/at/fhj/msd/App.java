package at.fhj.msd;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Node<Integer> n = new Node<>(1);
        MyQueueList <Integer> i = new MyQueueList<>(n);
        //System.out.println(i.size());
        i.put(3);
        //System.out.println(i.size());
        i.put(4);
        System.out.println(i.get());
        System.out.println(i.get());
        System.out.println(i.get());
        i.put(3);
        System.out.println(i.get());
        
        

    }
}
