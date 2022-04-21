package project5;

import student.TestCase;

/**
 * Test class for State
 * 
 * @author James Wallace, Sam Klemic
 * @version 2022/04/21
 */
public class StateTest extends TestCase {
    // ~ Fields.................................................................
    private State test;
    private LinkedList<Race> raceList;

    // ~ Methods................................................................
    /**
     * Set Up method for the test class.
     */
    public void setUp() {
        raceList = new LinkedList<Race>();
        raceList.add(new Race("test", 23, 13));
        raceList.add(new Race("zanzibar", 20, 19));
        raceList.add(new Race("actor", 20, 1));
        test = new State("Virginia", raceList);
    }


    /**
     * Test method for getStateName().
     */
    public void testGetStateName() {
        assertEquals("Virginia", test.getStateName());
    }


    /**
     * Test method for getRaceList().
     */
    public void testGetRaceList() {
        assertEquals(raceList, test.getRaceList());
    }


    /**
     * Test method for sortAlpha().
     */
    public void testSortAlpha() {
        LinkedList<Race> sorted = new LinkedList<Race>();
        sorted.add(new Race("actor", 20, 1));
        sorted.add(new Race("test", 23, 13));
        sorted.add(new Race("zanzibar", 20, 19));
        test.sortAlpha();
        while (!sorted.isEmpty()) {
            assertEquals(sorted.remove().getRaceName(), ((Race)test
                .getRaceList().remove()).getRaceName());
        }
    }


    /**
     * Test method for sortCFR().
     */
    public void testSortCFR() {
        LinkedList<Race> sorted = new LinkedList<Race>();
        sorted.add(new Race("actor", 20, 1));
        sorted.add(new Race("test", 23, 13));
        sorted.add(new Race("zanzibar", 20, 19));
        test.sortCFR();
        while (!sorted.isEmpty()) {
            assertEquals(sorted.remove().getRaceName(), ((Race)test
                .getRaceList().remove()).getRaceName());
        }
    }

}
