package at.fhj.msd;

import java.util.NoSuchElementException;


public class MyStackList<E> {

    Node<E> head;
    Node<E> tail;
    int size = 1;


    public MyStackList(Node<E> head) {
        this.head = head;
        this.tail = head;
    }

    public int size() {

        return size;

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(E newElement) {
        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E pop() {

        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        E data = head.data;
        head = head.next;
        size--;
        return data;

    }

    public E first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        return head.data;
    }

    public E last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public void addFirst(E newElement) {

        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
        size++;

    }

    public void addLast(E newElement) {

        Node<E> newNode = new Node<>(newElement);

        if (this.isEmpty()) {
            head = newNode;
            tail = head;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void deleteFirst() {

        if (!this.isEmpty()) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
        }

    }

    public void deleteLast() {
        Node<E> current = head;

        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            tail = null;
            size--;
            return;
        }

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        tail = current;
        size--;

    }

    public void clear() {
        head = null;
        tail = null;
        this.size = 0;
    }

    public String listAsString() {

        StringBuilder text = new StringBuilder();

        if (this.isEmpty()) {
            text.append("null");
            return text.toString();
        }

        Node<E> current = head;
        while (current != null) {
            text.append(current.data).append(" -> ");
            current = current.next;
        }

        text.append("null");

        return text.toString();

    }

}
