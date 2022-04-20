/**
 * 
 */
package project5;

/**
 * Custom made linked list interface
 * 
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * - Sam Klemic 9063-12128
 * 
 * @param <T>
 * 
 * @author Sam
 *
 */
public interface LinkedListInterface<T> {

    /**
     * Adds the param value to the end of the list
     * 
     * @param value
     *            value to be added
     */
    public abstract void add(T value);


    /**
     * Removes the last item of the list
     * 
     * @return removed value
     */
    public abstract T remove();


    /**
     * Removes the param item from the list
     * 
     * @param value
     *            value to be removed
     * @return removed value
     */
    public abstract T remove(T value);


    /**
     * Empties the list
     */
    public abstract void clear();


    /**
     * Checks if the list is empty
     * 
     * @return emptiness
     */
    public abstract boolean isEmpty();


    /**
     * Gets the size of the list
     * 
     * @return size
     */
    public abstract int size();


    /**
     * Returns an array of all list content
     * 
     * @return array of list
     */
    public abstract Object[] toArray();


    /**
     * Returns a string of the list content
     * 
     * @return string of list content
     */
    public abstract String toString();

}
