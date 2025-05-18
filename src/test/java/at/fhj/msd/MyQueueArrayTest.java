package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyQueueArrayTest {


      MyQueueArray<Integer> mqa;
      
      /*----------------------------------------------------------*
      |                      Setup Section                       |
      *----------------------------------------------------------*/
      @BeforeEach
      public void setup()
      {
      mqa = new MyQueueArray<>(5, Integer.class);
      }
      
      /*----------------------------------------------------------*
      |                        Size Test                         |
      *----------------------------------------------------------*/
      @Test
      @DisplayName("size() Test")
      void sizeTest()
      {
            assertEquals(0,mqa.size());
            mqa.put(4);
            assertEquals(1, mqa.size());
            mqa.put(3);
            mqa.get();
            mqa.put(4);
            mqa.get();
            assertEquals(1, mqa.size());
            mqa.get();
            assertEquals(0, mqa.size());
      }
      
      /*----------------------------------------------------------*
      |                      isEmpty Test                        |
      *----------------------------------------------------------*/
      @Test
      @DisplayName("isEmpty() Test")
      void isEmptyTest()
      {
            assertEquals(true,mqa.isEmpty());
            mqa.put(1);
            assertEquals(false, mqa.isEmpty());
      }

      /*----------------------------------------------------------*
      |                      put() Test                          |
      *----------------------------------------------------------*/
      @Test
      @DisplayName("put() Test")
      void putTest()
      {
            mqa.put(1);
            assertEquals(1, mqa.size());
            mqa.put(2);
            assertEquals(2, mqa.size());
            mqa.put(3);
            assertEquals(3, mqa.size());
            mqa.put(4);
            assertEquals(4, mqa.size());
            mqa.put(5);
            assertEquals(5, mqa.size());
      }
}
