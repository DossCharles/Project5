package prj5;

import java.awt.Color;
import java.util.Iterator;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Creates and updates the front-end of the program
 * Requires instantiation with filled LinkedList<State> to function
 * 
 * @author Sam Klemic
 *
 * @version 04.26.2022
 */
public class GUIWindow {

    private Window window;
    private Button sortAlpha;
    private Button sortCFR;
    private Button[] stateButtons;
    private Shape[] bars;

    private Button quitButton;

    private LinkedList<State> states;
    private State displayedState;

    private int barsX = 135;
    private int barsY = 225;
    private int barsWidth = 35;
    private int heightMultiplier = 25;

    /**
     * Constructs the window
     * 
     * @param stateParam
     *            state linked list to be displayed
     */
    public GUIWindow(LinkedList<State> stateParam) {
        // Creates window and sets title
        window = new Window();
        window.setTitle("COVID Statistic Visualizer");

        // Passes state list from param
        states = stateParam;

        stateButtons = new Button[stateParam.size()];

        sortAlpha = new Button("Sort Alpha");
        sortAlpha.onClick(this, "clickedAlpha");

        sortCFR = new Button("Sort CFR");
        sortCFR.onClick(this, "clickedCFR");

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");

        // Add upper buttons to window
        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);

        // Fills the bars and stateButtons array
        Iterator<State> iterator = states.iterator();
        for (int i = 0; i < states.size(); i++) {
            State stateFound = ((State)iterator.next());

            String stateName = stateFound.getStateName();

            // Sets default displayed state to DC sorted alphabetically
            // Initializes bar size
            if (i == 0) {
                displayedState = stateFound;
                displayedState.sortAlpha();
                bars = new Shape[displayedState.getRaceList().size()];
            }

            stateButtons[i] = new Button("Represent " + stateName);
            // Has the button reference one of 6 clickedState methods
            // Assumes there are 6 states, DC, GA, MD, NC, TN, VA
            stateButtons[i].onClick(this, "clickedState" + stateName);

            window.addButton(stateButtons[i], WindowSide.SOUTH);
        }

        updateBars();

    }


    /**
     * Handles sorting the data when Alphabetical sort is selected
     * 
     * @param button
     *            sortAlpha button
     */
    public void clickedAlpha(Button button) {
        displayedState.sortAlpha();
        updateBars();

    }


    /**
     * Handles sorting the data when CFR sort is selected
     * 
     * @param button
     *            sortCFR button
     */
    public void clickedCFR(Button button) {
        displayedState.sortCFR();
        updateBars();

    }


    /**
     * Handles quiting the program
     * 
     * @param button
     *            quitButton
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Updates the bars to match the data of the displayed state
     */
    private void updateBars() {
        window.removeAllShapes();
        LinkedList<Race> raceData = displayedState.getRaceList();
        Iterator<Race> raceDataIterator = raceData.iterator();

        for (int i = 0; i < bars.length; i++) {
            // Sets the bar height to be relative to the CFR percentage
            Race currentRace = (Race)raceDataIterator.next();
            int barHeight = (int)(currentRace.getCFR() * heightMultiplier);
            // Find adjusted position for each bar;
            int adjustedBarX = barsX + (3 * barsWidth) * i;
            int adjustedBarY = barsY - barHeight;
            bars[i] = new Shape(adjustedBarX, adjustedBarY, barsWidth,
                barHeight);
            bars[i].setBackgroundColor(Color.BLUE);
            bars[i].setForegroundColor(Color.BLACK);

            // Create text for bottom of bar
            String raceText = currentRace.getRaceName();
            String CFRText = currentRace.getCFR() + "%";
            TextShape raceTextShape = new TextShape(adjustedBarX, barsY + 10,
                raceText, Color.BLACK);
            TextShape raceCFRShape = new TextShape(adjustedBarX, barsY + 25,
                CFRText, Color.BLACK);

            // Add bar shape and text to window
            window.addShape(bars[i]);
            window.addShape(raceTextShape);
            window.addShape(raceCFRShape);
        }

    }


    /**
     * Changes the displayed state to DC
     * 
     * @param button
     *            stateButtons[0] button
     */
    public void clickedStateDC(Button button) {
        Iterator<State> stateIterator = states.iterator();

        // Iterates through the list to find the appropriate state
        while (stateIterator.hasNext()) {
            State currentState = stateIterator.next();
            if (currentState.getStateName().equals("DC")) {
                displayedState = currentState;
                updateBars();
                break;
            }
        }
    }


    /**
     * Changes the displayed state to GA
     * 
     * @param button
     *            stateButtons[1] button
     */
    public void clickedStateGA(Button button) {
        Iterator<State> stateIterator = states.iterator();

        // Iterates through the list to find the appropriate state
        while (stateIterator.hasNext()) {
            State currentState = stateIterator.next();
            if (currentState.getStateName().equals("GA")) {
                displayedState = currentState;
                updateBars();
                break;
            }
        }
    }


    /**
     * Changes the displayed state to MD
     * 
     * @param button
     *            stateButtons[2] button
     */
    public void clickedStateMD(Button button) {
        Iterator<State> stateIterator = states.iterator();

        // Iterates through the list to find the appropriate state
        while (stateIterator.hasNext()) {
            State currentState = stateIterator.next();
            if (currentState.getStateName().equals("MD")) {
                displayedState = currentState;
                updateBars();
                break;
            }
        }
    }


    /**
     * Changes the displayed state to NC
     * 
     * @param button
     *            stateButtons[3] button
     */
    public void clickedStateNC(Button button) {
        Iterator<State> stateIterator = states.iterator();

        // Iterates through the list to find the appropriate state
        while (stateIterator.hasNext()) {
            State currentState = stateIterator.next();
            if (currentState.getStateName().equals("NC")) {
                displayedState = currentState;
                updateBars();
                break;
            }
        }
    }


    /**
     * Changes the displayed state to TN
     * 
     * @param button
     *            stateButtons[4] button
     */
    public void clickedStateTN(Button button) {
        Iterator<State> stateIterator = states.iterator();

        // Iterates through the list to find the appropriate state
        while (stateIterator.hasNext()) {
            State currentState = stateIterator.next();
            if (currentState.getStateName().equals("TN")) {
                displayedState = currentState;
                updateBars();
                break;
            }
        }
    }


    /**
     * Changes the displayed state to VA
     * 
     * @param button
     *            stateButtons[5] button
     */
    public void clickedStateVA(Button button) {
        Iterator<State> stateIterator = states.iterator();

        // Iterates through the list to find the appropriate state
        while (stateIterator.hasNext()) {
            State currentState = stateIterator.next();
            if (currentState.getStateName().equals("VA")) {
                displayedState = currentState;
                updateBars();
                break;
            }
        }
    }

}
