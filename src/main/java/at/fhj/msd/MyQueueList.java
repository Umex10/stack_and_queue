package at.fhj.msd;

public class MyQueueList<E> {

      private E Element;
      private int size = 1;
      private Node<E> head;
      @SuppressWarnings("unused")
      private Node<E> tail;
      private Node<E> pointer;
      
      public MyQueueList (Node<E> NodeElement)
      {
            this.head = NodeElement;
            this.tail = NodeElement;
      }

      public int size() {return this.size;}

      public boolean isEmpty() {return size == 0;}

      public void put(E Element)
      {
            Node<E> newNode = new Node<>(Element);
            this.tail = newNode;
            if (isEmpty() == true) {head = newNode;}
            else if (size() == 1) {head.prev = newNode; pointer = head.prev;}
            else if (size() >= 2) {pointer.prev = newNode; pointer = pointer.prev;}
            ++this.size;
      }

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
