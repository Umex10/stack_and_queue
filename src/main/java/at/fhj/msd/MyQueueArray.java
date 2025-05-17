package at.fhj.msd;

import java.lang.reflect.Array;

public class MyQueueArray<E> {

      private int size;
      private E[] queue;
      Class<E> clazz;

      /**
       * Constructs a new MyQueueArray with the specified initial size.
       *
       * @param initialSize the initial size of the queue array
       * @param clazz       the class type of the generic element
       */
      public MyQueueArray(int maxSize, Class<E> clazz) {
            this.clazz = clazz;
            this.size = 0;
            this.queue = (E[]) Array.newInstance(clazz, maxSize);
            this.size = -1;
      }

      /**
       * Returns the current number of elements in the queue.
       *
       * @return the size of the queue
       */
      public int size() {return size + 1;}

      /**
       * Checks if the queue is empty.
       * @return true if the queue is empty, false otherwise.
       */
      public boolean isEmpty() {return size == -1;}

      private int pointer1;
      private int pointer2;

      public void put(E Element) {
          pointer1 = 1;
          pointer2 = size();

            while (pointer2 > pointer1)
            {
                  queue[pointer1] = queue[pointer1 - 1];
                  queue[pointer2] = queue[pointer2 - 1];
                  ++pointer1;
                  --pointer2;
            }
            queue[0] = Element;
            ++size;
      }

     
      public E get()
      {
            if (isEmpty() == true)
            {throw new IllegalArgumentException("Cannot delete from empty queue");}
            else{
                  --size;
                  queue[size()] = null;
                  return queue[size() -1];
            }           
      }

}
