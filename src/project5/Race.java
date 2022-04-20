package project5;

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
     * @return the CFR rounded to 1 decimal.
     */
    public double getCFR() {
        double temp = ((double)deaths/cases)*100;
        double scale = 10.0;
        return Math.round(temp*scale)/scale;
    }
    
    /**
     * Compares two races by CFR.
     * @return 1 if this is greater than other.
     */
    public int compareToCFR(Race other) {
        if(getCFR() > other.getCFR()) {
            return 1;
        }
        else if (getCFR() < other.getCFR()) {
            return -1;
        }
        return 0;
        
        
    }
    
    /**
     * Compares two races alphabetically.
     * 
     */
    public int compareToAlpha(Race other) {
        if (getRaceName().compareTo(other.getRaceName()) > 0) {
            return 1;
        }
        else if (getRaceName().compareTo(other.getRaceName()) < 0) {
            return -1;
        }
        return 0;
    }

}
