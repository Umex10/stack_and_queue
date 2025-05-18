package at.fhj.msd;

import java.lang.reflect.Array;

public class MyQueueArray<E> {


      private int size;
      /**
       * The size parameter is used to keep track of the number of elements in the queue.
       * It is initialized to -1 because the queue starts with no elements.
       * It then increments by 1 every time an element is added to the queue.
       * It decrements by 1 every time an element is removed from the queue.
       */
      private int maxSize;
      /**
       * The maxSize parameter is used to keep track of the maximum number of elements that can be stored in the queue.
       * It is initialized to the size of the array.
       */
      private E[] queue;
      Class<E> clazz;

      /**
       * Constructs a new MyQueueArray with the specified initial size.
       *
       * @param initialSize the initial size of the queue array
       * @param clazz       the class type of the generic element
       */
      public MyQueueArray(int maxSize, Class<E> clazz) {
            this.maxSize = maxSize;
            this.clazz = clazz;
            this.queue = (E[]) Array.newInstance(clazz, maxSize);
            this.size = -1;
      }

      /**
       * Returns the current number of elements in the queue.
       *
       * @return the size of the queue
       */
      public int size() {return this.size + 1;}

      /**
       * Checks if the queue is empty.
       * @return true if the queue is empty, false otherwise.
       */
      public boolean isEmpty() {return this.size == -1;}

      /**
       * puts an element into the queue.
       * The element is added to the back of the queue.
       * The queue is a FIFO (First In First Out) data structure.
       * It also checks if the queue is full before adding an element.
       * If the queue is full, it throws an IllegalArgumentException.
       * @param Element
       * @throws IllegalArgumentException if the queue is full
       */
      public void put(E Element) {

          if (size() >= maxSize) 
          {throw new IllegalArgumentException("Queue is full");} 

            if (isEmpty()) {queue[0] = Element;}
            else {
                  for (int i = size(); i > 0; i--) {
                        queue[i] = queue[i - 1]; 
                  }
                  queue[0] = Element; 
            }
            ++size;
      }

      /**
       * removes an element from the queue.
       * The element is removed from the front of the queue.
       * The queue is a FIFO (First In First Out) data structure.
       * It also checks if the queue is empty before removing an element.
       * If the queue is empty, it throws an IllegalArgumentException.
       * @return the deleted element
       * @throws IllegalArgumentException if the queue is empty
       */
      public E get()
      {
            if (isEmpty() == true)
            {throw new IllegalArgumentException("Cannot delete from empty queue");}
            else{
                  E deleted = queue[this.size];
                  queue[this.size] = null;
                  --size;
                  return deleted;
            }           
      }

}
