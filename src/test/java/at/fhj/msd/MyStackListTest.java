package at.fhj.msd;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyStackListTest {

    MyStackList<Integer> list;

    /*----------------------------------------------------------*
     |                      Setup Section                       |
     *----------------------------------------------------------*/
    @BeforeEach
    void setup() {
        Node<Integer> node = new Node<>(3);

        list = new MyStackList<>(node);

    }

    /*----------------------------------------------------------*
     |                        Size Test                         |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("size() Test")
    void SizeTest() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        assertEquals(5, list.size());

    }

    /*----------------------------------------------------------*
     |                   push and pop Tests                      |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("push() Test")
    void pushTest() {
        list.push(4);
        assertEquals("4 -> 3 -> null", list.listAsString());
    }

    @Test
    @DisplayName("pop() Test")
    void popTest() {
        list.pop();
        assertEquals("null", list.listAsString());
        assertEquals(null, list.pop());
    }

    /*----------------------------------------------------------*
     |                  Access elements Tests                   |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("first() Test")
    void firstTest() {
        assertEquals(3, list.first());
    }

    @Test
    @DisplayName("first() Test")
    void firstTest2() {
        list.addFirst(4);
        list.addFirst(5);
        assertEquals(5, list.first());
    }

    @Test
    @DisplayName("first() NoSuchElementArgument Test")
    void firstIllegalTest() {
        list.deleteFirst();
        assertThrows(NoSuchElementException.class, () -> {
            list.first();
        });
    }

    @Test
    @DisplayName("last() Test")
    void lastTest() {
        assertEquals(3, list.last());
    }

    @Test
    @DisplayName("last() Test")
    void lastTest2() {
        list.addFirst(4);
        list.addFirst(5);
        assertEquals(3, list.last());
    }

    @Test
    @DisplayName("last() NoSuchElementArgument Test")
    void lastIllegalTest() {
        list.deleteFirst();
        assertThrows(NoSuchElementException.class, () -> {
            list.last();
        });
    }

    /*----------------------------------------------------------*
     |                      add() Tests                         |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("addFirst() Test")
    void addFirstTest() {
        list.addFirst(4);
        assertEquals(4, list.first());
    }

    @Test
    @DisplayName("addLast() Test")
    void addLastTest() {
        list.addLast(4);
        assertEquals(4, list.last());

    }

    @Test
    @DisplayName("addLast() - head=null Test")
    void addLastNullTest() {
        list.deleteFirst();
        list.addLast(3);
        assertEquals("3 -> null", list.listAsString());

    }

    /*----------------------------------------------------------*
     |                     delete() Tests                       |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("deleteFirst() Test")
    void deleteFirst() {
        list.deleteFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("deleteFirst() Test")
    void deleteFirst2() {
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(6);
        list.deleteFirst();
        assertEquals(3, list.first());
    }

    @Test
    @DisplayName("deleteLast() Test")
    void deleteLastTest() {
        list.deleteLast();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("deleteLast() Test")
    void deleteLastTest2() {
        list.addLast(5);
        list.addLast(7);
        list.deleteLast();
        assertEquals(5, list.last());
    }

    @Test
    @DisplayName("deleteLast() List-String Test")
    void deleteLastStringTest() {
        list.addLast(5);
        list.deleteLast();
        assertEquals("3 -> null", list.listAsString());
    }

    /*----------------------------------------------------------*
     |                   list as String Tests                   |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("listAsString() Test")
    void listAsStringTest() {
        list.addLast(4);
        list.addLast(5);
        assertEquals("3 -> 4 -> 5 -> null", list.listAsString());
    }

    @Test
    @DisplayName("listAsString()")
    void listAsStringTest2() {
        list.deleteFirst();
        assertEquals("null", list.listAsString());
    }

}
