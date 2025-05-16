package at.fhj.msd;

import java.util.NoSuchElementException;

public class MyStackList<E> {

    Node<E> head;

    public MyStackList(Node<E> head) {
        this.head = head;

    }

    public int size() {
        Node<E> current = head;
        int count = 1;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(E newElement) {
        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
    }

    public Node<E> pop() {
        if (head != null) {
            Node<E> newNode = head;
            head = head.next;
            return newNode;
        }

        return null;
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

    }

    public void addLast(E newElement) {

        Node<E> newNode = new Node<>(newElement);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

    }

    public void deleteFirst() {

        if (head != null) {
            head = head.next;
        }

    }

    public void deleteLast() {
        Node<E> current = head;

        if (current == null || current.next == null) {
            head = null;
        }

        while (current.next != null) {
            if (current.next.next == null) {
                current.next = null;
                break;
            } else {
                current = current.next;
                current.next = current.next.next;
            }

        }

    }

    public String listAsString() {

        StringBuilder text = new StringBuilder();

        if (this.isEmpty()) {
            text.append("null");
        }

        Node<E> current = head;
        while (current != null) {
            text.append(current.data).append(" -> ");
            current = current.next;
        }

        if (this.isEmpty()) {

        } else {
            text.append("null");
        }

        return text.toString();

    }

}
