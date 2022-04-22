package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;
import student.TestCase;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Timothy Doss (timothy20)
/**
 * 
 * Data handler test
 * 
 * @author Timothy Doss
 * @version 1.0
 */
public class DataHandlerTest extends TestCase {

    // fields
    private DataHandler reader;

    /**
     * Basic set up method
     */
    public void setUp() throws FileNotFoundException, ParseException {
        reader = new DataHandler("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }


    /**
     * Testing setup
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void test() throws ParseException {
        LinkedList<State> states = reader.getStates();
        Iterator<State> iter = states.iterator();

        assertEquals(iter.next().getStateName(), "DC");
        assertEquals(iter.next().getStateName(), "GA");
        assertEquals(iter.next().getStateName(), "MD");
        assertEquals(iter.next().getStateName(), "NC");
        assertEquals(iter.next().getStateName(), "TN");
        assertEquals(iter.next().getStateName(), "VA");

        Iterator<State> iter2 = states.iterator();
        State testState = iter2.next();
        Iterator<Race> iter3 = testState.getRaceList().iterator();
        assertEquals(iter3.next().toString2(),
            "White Cases: 70678 Deaths: 1924");

        Iterator<State> iter4 = states.iterator();
        iter4.next();
        iter4.next();
        iter4.next();
        iter4.next();
        iter4.next();
        State testState2 = iter4.next();
        System.out.print(testState2.sortAlpha().toString() + "\n");
        System.out.print(testState2.sortCFR().toString());

    }
}
