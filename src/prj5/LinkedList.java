// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Samuel Klemic 9063-12128

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List of nodes with implemented methods
 * 
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor will I accept the actions of those who
 * do.
 * - Sam Klemic 9063-12128
 * 
 * @author Sam
 *
 * @param <E>
 * 
 * @version 04.11.2022
 */
public class LinkedList<E> implements LinkedListInterface<E> {

    private Node<E> first;
    private int size;

    /**
     * Constructs an empty LinkedList
     */
    public LinkedList() {
        first = null;
        size = 0;
    }


    /**
     * Constructs a list with a first node
     * 
     * @param firstNode
     *            is our firstNode
     */
    public LinkedList(Node<E> firstNode) {
        first = firstNode;
        size = 1;
    }


    /**
     * Adds the param item to the end of the list
     * 
     * @param value
     *            value to be added to the list
     */
    @Override
    public void add(E value) {
        if (first == null) {
            first = new Node<E>(value);
            size++;
        }
        else {
            Node<E> curr = first;

            while (curr.next() != null) {
                curr = curr.next();
            }

            curr.setNext(new Node<E>(value));
            size++;
        }
    }


    /**
     * Removes the last node in the list
     * 
     * @return data in removed node
     */
    @Override
    public E remove() {
        E removed = null;

        if (first == null) {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        else if (first.next() == null) {
            removed = first.getData();
            first = null;
            size--;
        }
        else {
            Node<E> curr = first;

            while (curr.next().next() != null) {
                curr = curr.next();
            }

            removed = curr.next().getData();
            curr.setNext(null);
            size--;
        }
        return removed;
    }


    /**
     * Removes param value from list
     */
    @Override
    public E remove(E value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        Node<E> curr = first;

        while (curr.next() != null) {
            if (curr.next().getData() == value) {
                E removed = curr.next().getData();
                curr.setNext(curr.next().next());
                size--;
                return removed;
            }
            curr = curr.next();
        }

        return null;
    }


    /**
     * Clears the list
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }


    /**
     * Returns boolean for if list is empty
     * 
     * @return boolean for emptiness
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the size of the list
     * 
     * @return size
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Returns array of linked list
     * 
     * @return array
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        Node<E> curr = first;
        for (int i = 0; i < size; i++) {
            array[i] = curr.getData();
            curr = curr.next();
        }

        return array;
    }


    /**
     * Returns string version of linked list
     * 
     * @return string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");

        Node<E> curr = first;
        for (int i = 0; i < size; i++) {
            builder.append(curr.getData());
            if (i != size - 1) {
                builder.append(", ");
            }
            curr = curr.next();
        }

        builder.append(")");
        return builder.toString();
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public LLIterator<E> iterator() {
        return new LLIterator<E>();
    }

    private static class Node<E> {
        private Node<E> next;
        private E data;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Creates new node with data d and next node
         * 
         * @param d
         *            data to put in node
         * @param next
         *            node to set as next
         */
        public Node(E d, Node<E> next) {
            data = d;
            this.next = next;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }


        /**
         * Sets the data of the node to the param
         * 
         * @param value
         */
        public void setData(E value) {
            data = value;
        }
    }


    /**
     * Internal iterator class
     * 
     * @author Sam
     *
     * @param <E>
     */
    private class LLIterator<E> implements Iterator<E> {

        private Node<E> next;

        /**
         * Creates a new DLListIterator
         */
        public LLIterator() {
            next = (Node<E>)first;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return (next != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() {
            if (hasNext()) {
                E data = next.getData();

                if (data == null) {
                    throw new NoSuchElementException();
                }

                next = next.next();
                return data;
            }
            else {
                throw new NoSuchElementException();
            }
        }

    }

}
