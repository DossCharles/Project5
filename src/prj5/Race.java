package prj5;

import java.text.DecimalFormat;

/**
 * Race class used as type in LinkedList
 * 
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * - James Wallace
 * 
 * 
 * @author James Wallace
 * @version 2022/04/19
 */
public class Race {
    // ~ Fields.................................................................
    private String raceName;
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
        this.raceName = race;
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
        return raceName;
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
        if (deaths == -1 || cases == -1) {
            return -1;
        }
        double cfr = (((double)deaths / cases) * 100);
        DecimalFormat df = new DecimalFormat("##.#");
        return Double.parseDouble(df.format(cfr));
    }


    /**
     * Returns string value of race
     * Used for Console data output
     * 
     * @return the string name with cases and its CFR
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.getRaceName());
        s.append(": ");
        s.append(this.getCases());
        s.append(" cases, ");
        if (this.getCFR() % 1 == 0) {
            int intValue = (int)(this.getCFR());
            s.append(intValue);
        }
        else {
            s.append(this.getCFR());
        }
        s.append("% CFR");
        return s.toString();
    }


    /**
     * A string rep of races
     * 
     * @return race deaths and cases
     */
    public String toString2() {
        return raceName + " Cases: " + cases + " Deaths: " + deaths;
    }

}
