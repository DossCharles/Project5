package project5;

import student.TestCase;

/**
 * 
 * @author Sam
 *
 * @verison 04.19.2022
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list1;
    private LinkedList<String> list2;
    
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
        
        
        Object[] arrayTest = {"A", "B", "C"};
        
        for (int i = 0; i < list1.size(); i++) {
            assertEquals(arrayTest[i], list1.toArray()[i]);
        }
    }
}
