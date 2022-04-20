package project5;

import java.util.Iterator;

/**
 * Class responsible for constructing each state.
 * 
 * @author James Wallace
 * @version 2022/04/19
 */

public class State<E> extends LinkedList {

    // ~ Fields.................................................................
    /**
     * The linked list of races.
     */
    public LinkedList<Race> raceList;
    private String name;

    // ~ Constructor............................................................
    /**
     * Constructor for the state class.
     * 
     * @param entry
     *            The name of the state
     * @param races
     *            The linked list of races used in each state.
     */

    public State(String entry, LinkedList<Race> races) {
        name = entry;
        raceList = races;
    }


    /**
     * Returns the name of the State.
     * 
     * @return the name of the State.
     * 
     */
    public String getStateName() {
        return name;
    }


    /**
     * Getter for the name of the State.
     * 
     * @return the name of the state.
     */
    public LinkedList<Race> getRaceList() {
        return raceList;
    }


    /**
     * Sorts the raceList in alphabetical order.
     */
    public void sortAlpha() {
        Iterator<Race> iter = raceList.iterator();
        for (int i = 0; i < raceList.size(); i++) {
            if 
        }

    }


    /**
     * Sorts the raceList by CFR.
     */
    public void sortCFR() {

    }

}
