package at.fhj.msd;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyStackArray<E> {

    E[] array;
    int top;
    Class<E> clazz;

    @SuppressWarnings("unchecked")
    public MyStackArray(int initialSize, Class<E> clazz) {

        this.clazz = clazz;
        this.array = (E[]) Array.newInstance(clazz, initialSize);
        this.top = -1;

    }

    public int size() {
        return top + 1;
    }

    public boolean isFull() {
        return size() == array.length;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(E newElement) {

        if (isFull()) {
            resize();
        }

        array[++top] = newElement;

    }

    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The array is empty!");
        }

        E element = peek();
        top--;
        return element;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The array is empty!");
        }

        return array[top];
    }

    @SuppressWarnings("unchecked")
    public void resize() {
        E[] newArray = (E[]) Array.newInstance(clazz, array.length * 2);
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;

    }

    public void clear() {
        top = -1;
    }

    public void clearComplete() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        top = -1;
    }

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
