package prj5;

/**
 * Creates the Race object.
 * 
 * @author James Wallace
 * @version 2022/04/19
 */
public class Race {
    // ~ Fields.................................................................
    private String race;
    private int cases;
    private int deaths;

    // ~ Constructor............................................................
    /**
     * Constructor for the race class.
     * 
     * @param race
     *            The race of the race
     * @param cases
     *            The number of cases
     * @param deaths
     *            The number of deaths
     */

    public Race(String race, Integer cases, Integer deaths) {
        this.race = race;
        this.cases = cases;
        this.deaths = deaths;
    }

    // ~ Methods................................................................


    /**
     * Getter for the RaceName.
     * 
     * @return the name of the race.
     */
    public String getRaceName() {
        return race;
    }


    /**
     * Getter for the number of cases.
     * 
     * @return the number of cases.
     */
    public int getCases() {
        return cases;
    }


    /**
     * Getter for the number of deaths.
     * 
     * @return the number of deaths.
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Gets the CFR for the race.
     * 
     * @return the CFR rounded to 1 decimal.
     */
    public double getCFR() {
        double temp = ((double)deaths / cases) * 100;
        if (temp == 100 || temp < 0) {
            return -1;
        }
        double scale = 10.0;
        return Math.round(temp * scale) / scale;
    }
    
    /**
     * Returns string value of race
     */
    public String toString() {
        return race + ": " + cases + " cases, " + getCFR() + "% CFR";
    }
    
    public String toString() {
        return race + " Cases: " + cases + " Deaths: " + deaths;
    }

}
