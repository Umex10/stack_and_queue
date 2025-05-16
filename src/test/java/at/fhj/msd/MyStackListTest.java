package at.fhj.msd;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    @DisplayName("size(): returns correct list size after multiple addFirst() calls")
    void sizeTest() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertEquals(5, list.size());
    }

    /*----------------------------------------------------------*
     |                      push / pop Tests                    |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("push(): element is added at the front")
    void pushTest() {
        list.push(4);
        assertEquals("4 -> 3 -> null", list.listAsString());
    }

    @Test
    @DisplayName("pop(): removes head and returns it, null if empty")
    void popTest() {
        list.pop();
        assertEquals("null", list.listAsString());
        assertNull(list.pop());
    }

    /*----------------------------------------------------------*
     |               Access Tests: first() / last()             |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("first(): returns current head")
    void firstTest() {
        assertEquals(3, list.first());
    }

    @Test
    @DisplayName("first(): returns new head after multiple addFirst() calls")
    void firstTestMultiple() {
        list.addFirst(4);
        list.addFirst(5);
        assertEquals(5, list.first());
    }

    @Test
    @DisplayName("first(): throws NoSuchElementException when list is empty")
    void firstIllegalTest() {
        list.deleteFirst();
        assertThrows(NoSuchElementException.class, () -> list.first());
    }

    @Test
    @DisplayName("last(): returns last element in list")
    void lastTest() {
        assertEquals(3, list.last());
    }

    @Test
    @DisplayName("last(): returns last even after multiple addFirst() calls")
    void lastTestMultiple() {
        list.addFirst(4);
        list.addFirst(5);
        assertEquals(3, list.last());
    }

    @Test
    @DisplayName("last(): throws NoSuchElementException when list is empty")
    void lastIllegalTest() {
        list.deleteFirst();
        assertThrows(NoSuchElementException.class, () -> list.last());
    }

    /*----------------------------------------------------------*
     |                         Add Tests                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("addFirst(): updates head correctly")
    void addFirstTest() {
        list.addFirst(4);
        assertEquals(4, list.first());
    }

    @Test
    @DisplayName("addLast(): appends element to the end")
    void addLastTest() {
        list.addLast(4);
        assertEquals(4, list.last());
    }

    @Test
    @DisplayName("addLast(): works when list was empty (head = null)")
    void addLastOnEmptyListTest() {
        list.deleteFirst();
        list.addLast(3);
        assertEquals("3 -> null", list.listAsString());
    }

    /*----------------------------------------------------------*
     |                       Delete Tests                       |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("deleteFirst(): removes head and updates tail if necessary")
    void deleteFirstTest() {
        list.deleteFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("deleteFirst(): removes only first, keeps rest intact")
    void deleteFirstPreservesRestTest() {
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(6);
        list.deleteFirst();
        assertEquals(3, list.first());
    }

    @Test
    @DisplayName("deleteFirst(): checks if lists is really empty")
    void deleteFirst_emptyListTest() {
        list.deleteFirst();
        list.deleteFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("deleteLast(): removes tail when single element")
    void deleteLastTestSingle() {
        list.deleteLast();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("deleteLast(): removes last node correctly")
    void deleteLastTestMultiple() {
        list.addLast(5);
        list.addLast(7);
        list.deleteLast();
        assertEquals(5, list.last());
    }

    @Test
    @DisplayName("deleteLast(): listAsString() reflects updated state")
    void deleteLastStringTest() {
        list.addLast(5);
        list.deleteLast();
        assertEquals("3 -> null", list.listAsString());
    }

    @Test
    @DisplayName("deleteLast(): safe when list is already empty")
    void deleteLastOnEmptyListTest() {
        list.deleteLast();
        list.deleteLast();
        assertEquals(0, list.size());
    }



    /*----------------------------------------------------------*
     |                       Clear Tests                        |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("clear(): resets head, tail, and size")
    void clearTest() {
        list.clear();
        assertEquals(0, list.size());
        assertNull(list.head);
        assertNull(list.tail);
    }

    /*----------------------------------------------------------*
     |                   List as String Tests                   |
     *----------------------------------------------------------*/
    @Test
    @DisplayName("listAsString(): returns correct string representation")
    void listAsStringTest() {
        list.addLast(4);
        list.addLast(5);
        assertEquals("3 -> 4 -> 5 -> null", list.listAsString());
    }

    @Test
    @DisplayName("listAsString(): returns 'null' when list is empty")
    void listAsStringEmptyTest() {
        list.deleteFirst();
        assertEquals("null", list.listAsString());
    }
}
