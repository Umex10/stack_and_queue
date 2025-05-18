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

      public void put(E Element) {

          if (size() + 1 > this.maxSize) {
              throw new IllegalArgumentException("Queue is full");
          }
          else
          {
            if (isEmpty() == true) {
                  queue[0] = Element;
                  ++this.size;
            }
            else
            {
                  int pointer1 = 1;
                  int pointer2 = size();
                  E[] copy = queue.clone();

                  while (pointer2 >= pointer1)
                  {
                    copy[pointer1] = queue[pointer1 - 1];
                    copy[pointer2] = queue[pointer2 - 1];
                    ++pointer1;
                    --pointer2;
                  }
                  this.queue = copy;
                  this.queue[0] = Element;
                  ++size;
            }
          }
      }

     
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
