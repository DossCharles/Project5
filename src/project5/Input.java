package project5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;

/**
 * Takes file input and includes the main method
 * 
 * @author Sam
 *
 * @version 04.21.2022
 */
public class Input {

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        DataHandler dataHandler = new DataHandler("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        LinkedList<State> states = dataHandler.getStates();
        
        Iterator stateIterator = states.iterator();
        
        while (stateIterator.hasNext()) {
            State currentState = (State)stateIterator.next();
            
            // Print alphabetical sort
            currentState.sortAlpha();
            
            System.out.println(currentState.getStateName());
            Iterator raceIteratorA = currentState.getRaceList().iterator();
            while (raceIteratorA.hasNext()) {
                Race currentRace = (Race)raceIteratorA.next();
                
                System.out.println(currentRace.toString());
            }
            System.out.println("=====");
            
            // Print CFR sort
            currentState.sortCFR();
            
            Iterator raceIteratorCFR = currentState.getRaceList().iterator();
            while (raceIteratorCFR.hasNext()) {
                Race currentRace = (Race)raceIteratorCFR.next();
                
                System.out.println(currentRace.toString());
            }
            System.out.println("=====");
        }
        
    }

}
