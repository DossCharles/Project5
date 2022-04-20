package project5;

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
    private Race more;
    private Race less;

    // ~ Methods................................................................

    /**
     * SetUp class for RaceTest.
     */
    public void setUp() {
        test = new Race("test", 23, 13);
        more = new Race("zanzibar", 20, 19);
        less = new Race("amish", 20, 1);
    }


    /**
     * Tests the getters in the class.
     */

    public void testBasics() {
        assertEquals("test", test.getRaceName());
        assertEquals(23, test.getCases());
        assertEquals(13, test.getDeaths());
        assertEquals(56.5, test.getCFR(), 0.1);
    }


    /**
     * Tests the compareToCFR method.
     */
    public void testCompareToCFR() {
        assertEquals(-1,test.compareToCFR(more));
        assertEquals(1,test.compareToCFR(less));
        assertEquals(0, test.compareToCFR(test));

    }
    
    /**
     * Tests the compareToAlpha method.
     */
    public void testCompareToAlpha() {
        assertEquals(-1,test.compareToAlpha(more));
        assertEquals(1,test.compareToAlpha(less));
        assertEquals(0, test.compareToAlpha(test));
    }

}
