package prj5;

import java.util.Iterator;

/**
 * Class responsible for constructing each state.
 * 
 * @author James Wallace, Sam Klemic
 * @version 2022/04/21
 * @param E
 *            is the generic
 */
public class State<E> extends LinkedList {

    // ~ Fields.................................................................
    private LinkedList<Race> raceList;
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
     * 
     * @return the sorted list
     */
    public LinkedList<Race> sortAlpha() {
        String alphabetReference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        LinkedList<Race> sortedList = new LinkedList<Race>();

        // Loops through alphabet adding list items if the correspond to current
        // alphabet letter
        // ends up with list sorted alphabetically
        // Doesn't account for two items of the same letter, but none of the
        // races are like that in use case
        for (int i = 0; i < alphabetReference.length(); i++) {
            Iterator iterator = raceList.iterator();

            while (iterator.hasNext()) {
                Race currentRace = (Race)iterator.next();
                char raceChar = (currentRace.getRaceName()).charAt(0);
                if (raceChar == alphabetReference.charAt(i)) {
                    sortedList.add(currentRace);
                }
            }
        }

        raceList = sortedList;
        return sortedList;

    }


    /**
     * Sorts the raceList by CFR.
     * Uses insertion sort to sort based on CFR
     * 
     * @return the sorted list
     */
    public LinkedList<Race> sortCFR() {
        LinkedList<Race> sortedList = new LinkedList<Race>();

        Object[] raceArray = raceList.toArray();

        for (int i = 1; i < raceArray.length; i++) {
            Race currentRace = (Race)raceArray[i];
            double currentRaceCFR = currentRace.getCFR();
            int j = i - 1;
            while (j >= 0 && currentRaceCFR > ((Race)raceArray[j]).getCFR()) {
                raceArray[j + 1] = raceArray[j];
                j--;
            }
            raceArray[j + 1] = currentRace;
        }

        for (int i = 0; i < raceArray.length; i++) {
            sortedList.add((Race)raceArray[i]);
        }

        raceList = sortedList;
        return sortedList;
    }

}
