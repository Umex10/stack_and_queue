package at.fhj.msd;

import java.util.NoSuchElementException;

/**
 * A singly linked list implementation that supports stack operations
 * and additional list-like functionality.
 *
 * @param <E> the type of elements stored in the list
 */
public class MyStackList<E> {

    Node<E> head;
    Node<E> tail;
    int size = 1;

    /**
     * Constructs a new list with the specified initial head node.
     *
     * @param head the initial node of the list
     */
    public MyStackList(Node<E> head) {
        this.head = head;
        this.tail = head;
    }

    /**
     * Returns the number of elements currently in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return {@code true} if the list contains no elements, {@code false} otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Pushes a new element onto the stack (adds at the head of the list).
     *
     * @param newElement the element to be added
     */
    public void push(E newElement) {
        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Removes and returns the element at the top of the stack (head of the list).
     *
     * @return the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public E pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Returns the first element in the list (head) without removing it.
     *
     * @return the first element
     * @throws NoSuchElementException if the list is empty
     */
    public E first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        return head.data;
    }

    /**
     * Returns the last element in the list (tail) without removing it.
     *
     * @return the last element
     * @throws NoSuchElementException if the list is empty
     */
    public E last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
        return tail.data;
    }

    /**
     * Adds a new element at the beginning of the list.
     *
     * @param newElement the element to add at the front
     */
    public void addFirst(E newElement) {
        Node<E> newNode = new Node<>(newElement);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds a new element at the end of the list.
     *
     * @param newElement the element to add at the end
     */
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

    /**
     * Removes the first element of the list.
     * If the list becomes empty after removal, the tail is set to {@code null}.
     */
    public void deleteFirst() {
        if (!this.isEmpty()) {
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
        }
    }

    /**
     * Removes the last element of the list.
     * If the list contains only one element, head and tail are set to {@code null}.
     */
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

    /**
     * Clears the list by resetting head, tail, and size to initial empty state.
     */
    public void clear() {
        head = null;
        tail = null;
        this.size = 0;
    }

    /**
     * Returns a string representation of the list elements
     * in the format: element1 -> element2 -> ... -> null
     *
     * @return a string representing the current list content
     */
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
