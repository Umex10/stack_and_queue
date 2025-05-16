package at.fhj.msd;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * A generic stack implementation using an array as the underlying data structure.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStackArray<E> {

    E[] array;
    int top;
    Class<E> clazz;

    /**
     * Constructs a new stack with a specified initial size.
     *
     * @param initialSize the initial size of the stack array
     * @param clazz       the class type of the generic element
     */
    @SuppressWarnings("unchecked")
    public MyStackArray(int initialSize, Class<E> clazz) {
        this.clazz = clazz;
        this.array = (E[]) Array.newInstance(clazz, initialSize);
        this.top = -1;
    }

    /**
     * Returns the current number of elements in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return top + 1;
    }

    /**
     * Checks if the stack is full.
     *
     * @return {@code true} if the stack is full, otherwise {@code false}
     */
    public boolean isFull() {
        return size() == array.length;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, otherwise {@code false}
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Pushes a new element onto the top of the stack.
     * Automatically resizes the stack if it is full.
     *
     * @param newElement the element to be pushed
     */
    public void push(E newElement) {
        if (isFull()) {
            resize();
        }
        array[++top] = newElement;
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the element removed from the top
     * @throws NoSuchElementException if the stack is empty
     */
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The array is empty!");
        }
        E element = peek();
        top--;
        return element;
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The array is empty!");
        }
        return array[top];
    }

    /**
     * Doubles the size of the internal array when the stack is full.
     */
    @SuppressWarnings("unchecked")
    public void resize() {
        E[] newArray = (E[]) Array.newInstance(clazz, array.length * 2);
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    /**
     * Clears the stack logically by resetting the top index.
     * The underlying array remains unchanged.
     */
    public void clear() {
        top = -1;
    }

    /**
     * Completely clears the stack by setting all elements to {@code null}
     * and resetting the top index.
     */
    public void clearComplete() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        top = -1;
    }

    /**
     * Returns a string representation of the stack in list format.
     *
     * @return the string representation of the stack
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder text = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            text.append(array[i]);
            if (i < top) {
                text.append(", ");
            }
        }
        text.append("]");
        return text.toString();
    }
}
