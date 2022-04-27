package prj5;

import java.util.Iterator;

/**
 * Class responsible for constructing each state.
 * 
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * - Sam Klemic 9063-12128
 * 
 * @author James Wallace, Sam Klemic
 * @version 2022/04/21
 * @param <E>
 *            is the generic
 */
public class State<E> extends LinkedList<Object> {

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
            Iterator<Race> iterator = raceList.iterator();

            while (iterator.hasNext()) {
                Race currentRace = (Race)iterator.next();
                char raceChar = (currentRace.getRaceName()).charAt(0);
                // Ensures char is capitalized
                raceChar = Character.toUpperCase(raceChar);
                
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
     * Uses selection sort to sort based on CFR
     * Returns sorted list
     * Largest CFR -> Smallest CFR (-1 at the end)
     * 
     *  
     * @return the sorted list
     */
    public LinkedList<Race> sortCFR() {
        //Ensures -1 values are added alphabetically
        sortAlpha();
        
        LinkedList<Race> sortedList = new LinkedList<Race>();
        
        int initialRaceSize = raceList.size();
        
        for (int i = 0; i < initialRaceSize; i++) {
            Iterator<Race> raceIterator = raceList.iterator();
            
            
            Race currentRace = raceIterator.next();
            
            Race maxRace = currentRace;
            
            while (raceIterator.hasNext()) {
                
                if (currentRace.getCFR() > maxRace.getCFR()) {
                    maxRace = currentRace;
                }
                
                currentRace = raceIterator.next();
            }
            
            // One more check for last value
            if (currentRace.getCFR() > maxRace.getCFR()) {
                maxRace = currentRace;
            }
            
            sortedList.add(raceList.remove(maxRace));
        }

        raceList = sortedList;
        return sortedList;
    }

}
