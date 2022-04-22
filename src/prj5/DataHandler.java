package prj5;

// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import list.AList;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Timothy Doss (timothy20)
/**
 * 
 * Data handler class which reads our file and organizes the data from it
 * can be used for any number of races
 * 
 * @author Timothy Doss
 * @version 1.0
 */
public class DataHandler {
    // Fields
    private LinkedList<State> statesList;

    /**
     * Simply calls our method to read said file
     * 
     * @param fileName
     *            name of the file input
     * @throws FileNotFoundException
     *             in case file cannot be found
     * @throws ParseException
     *             in case we mess up how we parse
     */
    public DataHandler(String fileName)
        throws FileNotFoundException,
        ParseException {
        statesList = readFile(fileName);
    }


    /**
     * Reads the file and organizes data
     * 
     * @param fileName
     *            name of file we parse
     * @return states which is our main data structure for our front end
     * @throws FileNotFoundException
     *             if file is not found
     * @throws ParseException
     *             if parsing goes wrong
     */
    private LinkedList<State> readFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        // Declaration of most of the variables I want to use
        LinkedList<State> states = new LinkedList<State>();
        LinkedList<Race> races;
        String[] raceNames = null;
        Integer[] cases = null;
        Integer[] deaths = null;
        int lineCount = 0;
        // Creating our scanner and starting our loop to iterate though the file
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            // Breaking each line up into a current line makes the data easier
            // to deal with
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",|\\s*\\n\\s*");
            // Using a list because we don't have a set number of races
            AList<String> tokens = new AList<String>();
            // gathering data
            while (currLine.hasNext()) {
                tokens.add(currLine.next());
            }
            currLine.close();
            // Start of organizing our data
            if (lineCount == 0) { // Start of first line Case
                // This variable is only needed for the first line so it should
                // only be initialized once
                raceNames = new String[tokens.getLength() / 2];
                // This takes the first half of the data which should just be
                // all of the race cases
                // then splits it since we know the race is always before Cases_
                // leaving us with just the race name
                int j = 0;
                for (int i = 1; i <= (tokens.getLength() / 2); i++) {
                    String[] raceName = tokens.getEntry(i).split("Cases_");
                    raceNames[j++] = raceName[1];
                }
                lineCount++;
            } // end of first line case
            else { // Start of every other line case
                  // Initialization of our token variables
                cases = new Integer[tokens.getLength() / 2];
                deaths = new Integer[tokens.getLength() / 2];
                races = new LinkedList<Race>();
                // Sorting our data
                // We know cases are in the first half while
                // deaths are in the second half of our data
                int x = 0;
                int y = 0;
                for (int i = 1; i < (tokens.getLength()); i++) {
                    // This covers the "NA" data problem we
                    // Simply return a -1 which we can then
                    // Deal with in our front end
                    if (tokens.getEntry(i).equals("NA")) {
                        tokens.replace(i, "-1");
                    }
                    if (i <= (tokens.getLength() / 2)) { // first half
                        cases[x++] = (Integer.parseInt(tokens.getEntry(i)));
                    }
                    else { // Second half of data
                        deaths[y++] = (Integer.parseInt(tokens.getEntry(i)));
                    }
                } // end of sorting data
                lineCount++;
                // Now we have to put the data together
                // First to make a state we need a LinkedList of all the races
                // for the state
                for (int i = 0; i < raceNames.length; i++) {
                    // the data is symmetrically so cases and deaths will match
                    // Races names was created at the start and doesn't change
                    Race tempRace = new Race(raceNames[i], cases[i], deaths[i]);
                    races.add(tempRace);
                } // end of making linked list for races
                  // The token at the start of every line except for the first
                  // one is the state name
                State state = new State(tokens.getEntry(0), races);
                states.add(state);
            } // end every other line case
        } // end of parsing data
        return states;
    } // end of readFile


    /**
     * Getter method for states
     * 
     * @return the states
     */
    public LinkedList<State> getStates() {
        return statesList;
    }
}
