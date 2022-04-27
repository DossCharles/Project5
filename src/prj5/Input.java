package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Iterator;

/**
 * Takes file input, generates GUI window and outputs data to console
 * 
 * 
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * - Sam Klemic 9063-12128
 * 
 * @author Sam
 *
 * @version 04.21.2022
 */
public class Input {

    @SuppressWarnings("rawtypes")
    public static void main(String[] args)
        throws FileNotFoundException{
        DataHandler dataHandler = null;
        if (args.length > 0) {
            try {
                dataHandler = new DataHandler(args[0]);
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            // If no argument is found use default data
            try {
                dataHandler = new DataHandler("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        LinkedList<State> states = null;
        try {
            states = dataHandler.getStates();
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        GUIWindow window = new GUIWindow(states);

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
