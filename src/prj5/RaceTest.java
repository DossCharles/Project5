package prj5;

import student.TestCase;

/**
 * Test class for race.
 * 
 * @author James Wallace
 * @version 2022/04/19
 */

public class RaceTest extends TestCase {
    // ~ Fields.................................................................
    private Race test;
    private Race test2;

    // ~ Methods................................................................

    /**
     * SetUp class for RaceTest.
     */
    public void setUp() {
        test = new Race("test", 23, 13);
        test2 = new Race("test", -1, 13);
    }


    /**
     * Tests the getters in the class.
     */

    public void testBasics() {
        assertEquals("test", test.getRaceName());
        assertEquals(23, test.getCases());
        assertEquals(13, test.getDeaths());
        assertEquals(56.5, test.getCFR(), 0.1);
        assertEquals(-1, test2.getCFR(), 0.1);
        test2 = new Race("test", 13, -1);
        assertEquals(-1, test2.getCFR(), 0.1);
    }


    /**
     * Testing to string
     */
    public void testToString() {
        assertEquals("test: 23 cases, 56.5% CFR", test.toString());
    }

}
