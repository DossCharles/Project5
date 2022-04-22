package prj5;

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

        LinkedList<State> states = null;
        try {
            states = dataHandler.getStates();
        }
        catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
