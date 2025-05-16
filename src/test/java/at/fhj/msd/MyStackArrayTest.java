package at.fhj.msd;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyStackArrayTest {

    MyStackArray<Integer> stackArray;

    /*----------------------------------------------------------*
     |                      Setup Section                       |
     *----------------------------------------------------------*/
    @BeforeEach
    void setup() {
        stackArray = new MyStackArray<>(5, Integer.class);
    }

    /*----------------------------------------------------------*
     |                        Size Test                         |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("size() Test")
    void sizeTest() {
        stackArray.push(3);
        stackArray.push(2);
        assertEquals(2, stackArray.size());
    }

    /*----------------------------------------------------------*
     |                      isEmpty Test                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("isEmpty Test")
    void isEmptyTest() {
        stackArray.push(3);
        stackArray.pop();
        assertTrue(stackArray.isEmpty());

        stackArray.push(3);
        assertFalse(stackArray.isEmpty());
    }

    /*----------------------------------------------------------*
     |                      isFull Test                         |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("isFull Test")
    void isFullTest() {
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(7);

        assertTrue(stackArray.isFull());
    }

    /*----------------------------------------------------------*
     |                      push() Tests                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("push() Test")
    void pushTest() {
        stackArray.push(4);
        stackArray.push(2);
        assertEquals(2, stackArray.peek());
    }

    @Test
    @DisplayName("push() isFull Test")
    void pushIsFullTest() {
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(7);

        stackArray.push(3);
        assertEquals(10, stackArray.array.length);
    }

    /*----------------------------------------------------------*
     |                      pop() Tests                         |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("pop() Test")
    void popTest() {
        stackArray.push(2);
        stackArray.push(4);
        assertEquals(4, stackArray.pop());
        assertEquals(1, stackArray.size());
    }

    @Test
    @DisplayName("pop() Illegal Test")
    void popIllegalTest() {
        stackArray.push(2);
        stackArray.pop();
        assertThrows(NoSuchElementException.class, () -> {
            stackArray.pop();
        });
    }

    /*----------------------------------------------------------*
     |                      peek() Tests                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("peek() Test")
    void peekTest() {
        stackArray.push(2);
        stackArray.peek();
        assertEquals(2, stackArray.peek());
    }

    @Test
    @DisplayName("peek() Illegal Test")
    void peekIllegalTest() {
        stackArray.push(2);
        stackArray.pop();

        assertThrows(NoSuchElementException.class, () -> {
            stackArray.peek();
        });
    }

    /*----------------------------------------------------------*
     |                      resize() Tests                      |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("resize() Test")
    void resizeTest() {
        stackArray.resize();
        assertEquals(10, stackArray.array.length);
    }

    @Test
    @DisplayName("resize() 2 Test")
    void resizeTest2() {
        stackArray.push(2);
        stackArray.push(3);
        stackArray.resize();
        assertEquals(3, stackArray.peek());
    }

    /*----------------------------------------------------------*
     |                      clear() Tests                       |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("clear() Test")
    void clearTest() {
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(7);

        stackArray.clear();
        assertEquals(0, stackArray.size());

        int length = stackArray.array.length;
        assertNotNull(stackArray.array[length - 1]);
    }

    @Test
    @DisplayName("clearComplete() Test")
    void clearCompleteTest() {
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);
        stackArray.push(6);
        stackArray.push(7);
        stackArray.clearComplete();
        assertEquals(0, stackArray.size());

        int length = stackArray.array.length;
        assertNull(stackArray.array[length - 1]);
    }

    /*----------------------------------------------------------*
     |                      toString Tests                      |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("arrayAsString() Test")
    void arrayAsStringTest() {
        stackArray.push(3);
        stackArray.push(4);
        stackArray.push(5);

        assertEquals("[3, 4, 5]", stackArray.toString());
    }

    @Test
    @DisplayName("arrayAsString() isEmpty Test")
    void arrayAsStringIsEmptyTest() {
        assertEquals("[]", stackArray.toString());
    }

}
