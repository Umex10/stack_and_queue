package at.fhj.msd;

public class Node<E> {

    E data;
    Node<E> next;
    Node<E> prev;


    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    } 
    
}
