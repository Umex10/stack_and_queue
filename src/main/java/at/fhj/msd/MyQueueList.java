package at.fhj.msd;

/**
 * The MyQueueList class implements a queue using a doubly linked list.
 * It provides methods to add elements to the queue and remove elements from it.
 * It works with generic types and works like a regular queue, so Elements are added to
 * the back of the queue and when Elements are deleted from the queue, 
 * the first Element added gets deleted.
 */
public class MyQueueList<E> {

      private E Element;
      private int size = 1;
      private Node<E> head;
      @SuppressWarnings("unused")
      private Node<E> tail;
      private Node<E> pointer;
      
      /**
       * Constructs a new MyQueueList with the specified initial node.
       *
       * @param NodeElement the initial node of the queue
       */
      public MyQueueList (Node<E> NodeElement)
      {
            this.head = NodeElement;
            this.tail = NodeElement;
      }

      /**
       * the size parameter is used to keep track of the number of elements in the queue.
       * It is initialized to 1 because the queue starts with one element.
       * It then increments by 1 every time an element is added to the queue.
       * It decrements by 1 every time an element is removed from the queue.
       * @return the number of elements currently in the queue.
       */
      public int size() {return this.size;}

      /**
       * Checks if the queue is empty.
       * @return true if the queue is empty, false otherwise.
       */
      public boolean isEmpty() {return size == 0;}

      /**
       * Adds a new element to the back of the queue.
       * This method creates a new node with the given element and updates the tail pointer.
       * If the queue is empty, it also sets the head pointer to the new node.
       * If the queue has only one element, it updates the head's previous pointer to point to the new node.
       * If the queue has two or more elements, it updates the pointer to point to the new node.
       * @param Element the element to be added to the queue.
       */
      public void put(E Element)
      {
            Node<E> newNode = new Node<>(Element);
            this.tail = newNode;
            if (isEmpty() == true) {head = newNode;}
            else if (size() == 1) {head.prev = newNode; pointer = head.prev;}
            else if (size() >= 2) {pointer.prev = newNode; pointer = pointer.prev;}
            ++this.size;
      }

      /**
       * Removes and returns the first element from the queue.
       * This method updates the head pointer to point to the previous node in the queue.
       * If the queue is empty, it throws an IllegalArgumentException.
       * @return the removed element from the queue.
       * @throws IllegalArgumentException if the queue is empty.
       */
      public E get()
      {
            if (isEmpty() == true) 
            {throw new IllegalArgumentException("Cannot delete from empty queue");}
            else{

                  Element = head.data;
                  head = head.prev;

            }
            --this.size;
            return Element;
      }

}
