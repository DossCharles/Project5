package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * 
 * @author Sam
 *
 * @version 04.19.2022
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list1;

    /**
     * Sets up variables in the test
     */
    public void setUp() {
        list1 = new LinkedList<String>();
    }


    /**
     * Tests the add method
     */
    public void testAdd() {
        list1.add("A");
        assertEquals(1, list1.size());
        list1.add("B");
        assertEquals(2, list1.size());

        assertEquals("(A, B)", list1.toString());
    }


    /**
     * Tests the remove() and remove(E) methods
     */
    public void testRemove() {

        try {
            list1.remove();
        }
        catch (IndexOutOfBoundsException e) {
            assertEquals("The list is empty", e.getMessage());
        }

        list1.add("A");
        assertEquals(1, list1.size());
        list1.add("B");
        assertEquals(2, list1.size());
        list1.add("C");
        assertEquals(3, list1.size());

        assertEquals("(A, B, C)", list1.toString());

        assertEquals("B", list1.remove("B"));
        assertEquals(2, list1.size());

        assertEquals("(A, C)", list1.toString());

        assertEquals("C", list1.remove());
        assertEquals(1, list1.size());

        assertEquals("(A)", list1.toString());

        try {
            list1.remove(null);
        }
        catch (IllegalArgumentException e) {
            assertEquals(null, e.getMessage());
        }
    }


    /**
     * Tests the clear() method
     */
    public void testClear() {
        list1.add("A");
        assertEquals(1, list1.size());
        list1.add("B");
        assertEquals(2, list1.size());
        list1.add("C");
        assertEquals(3, list1.size());

        list1.clear();

        assertEquals(0, list1.size());
        assertEquals("()", list1.toString());
    }


    /**
     * Tests the toArray() method
     */
    public void testArray() {
        list1.add("A");
        assertEquals(1, list1.size());
        list1.add("B");
        assertEquals(2, list1.size());
        list1.add("C");
        assertEquals(3, list1.size());

        Object[] arrayTest = { "A", "B", "C" };

        for (int i = 0; i < list1.size(); i++) {
            assertEquals(arrayTest[i], list1.toArray()[i]);
        }
    }


    /**
     * Tests iterator
     */
    public void testIterators() {

        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        Iterator<String> iter = list1.iterator();

        assertTrue(iter.hasNext());
        assertEquals("A", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("B", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("C", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("D", iter.next());
        assertFalse(iter.hasNext());

        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            assertEquals(null, e.getMessage());
        }

    }
}
