package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;
import student.TestCase;

public class DataHandlerTest extends TestCase {

    // fields
    private DataHandler reader;

    public void setUp() throws FileNotFoundException, ParseException {
        reader = new DataHandler(
            "Cases_and_Deaths_by_race_CRDT_Sep2020(1).csv");
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void test() {
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
        Iterator<Race> iter3 = testState.raceList.iterator();
        assertEquals(iter3.next().toString2(),
            "White Cases: 70678 Deaths: 1924");
    }
}
