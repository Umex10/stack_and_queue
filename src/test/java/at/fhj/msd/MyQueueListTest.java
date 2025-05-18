package at.fhj.msd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// Add the following import if Node is in the same package or adjust the package accordingly




public class MyQueueListTest {

      MyQueueList<Integer> mql;

      /*----------------------------------------------------------*
     |                      Setup Section                       |
     *----------------------------------------------------------*/
      @BeforeEach
      public void setup()
      {
        mql = new MyQueueList<>(new Node<>(1));
      }

      /*----------------------------------------------------------*
     |                        Size Test                         |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("size() Test")
    void sizeTest()
    {
      assertEquals(1,mql.size());
      mql.put(4);
      assertEquals(2, mql.size());
      mql.put(3);
      mql.get();
      mql.put(4);
      mql.get();
      assertEquals(2, mql.size());
      mql.get();
      mql.get();
      assertEquals(0, mql.size());
    }

     /*----------------------------------------------------------*
     |                      isEmpty Test                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("isEmpty() Test")
    void isEmptyTest()
    {
      assertEquals(false,mql.isEmpty());
      mql.get();
      assertEquals(true, mql.isEmpty());
      mql.put(1);
      assertEquals(false, mql.isEmpty());
    }

      /*----------------------------------------------------------*
     |                      put() Tests                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("put() Test")
    void putTest()
    {
      mql.get();

      mql.put(1);
      mql.put(2);
      mql.put(3);

      assertEquals(3, mql.size());

      assertEquals(1, mql.get());  
      assertEquals(2, mql.get());
      assertEquals(3, mql.get());
      
    }

      /*----------------------------------------------------------*
     |                      get() Tests                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("get() Test")
    void getTest()
    {
      mql.get();
      assertThrows(IllegalArgumentException.class, () -> mql.get());
    }

}
