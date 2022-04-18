// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// - Samuel Klemic 9063-12128

package project5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * 
 * @author Sam
 *
 * @param <E>
 * 
 * @version 04.11.2022
 */
public class LinkedList<E> implements ListInterface<E> {

    private Node<E> first;
    private int size;

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
    }


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
            return (next.next().getData() != null);
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
            E data = next.next().getData();

            if (data == null) {
                throw new NoSuchElementException();
            }

            next = next.next();
            return data;
        }

    }

    /**
     * Constructs and empty linked list
     */
    public LinkedList() {
        first = null;
    }


    /**
     * Constructs a linked list with a first value
     * 
     * @param value
     *            first value in list
     */
    public LinkedList(E value) {
        first = new Node<E>(value);
        size = 1;
    }


    /**
     * Adds param element to the end of list
     * 
     * @param value
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
     * Adds a new node of value at an index
     * 
     * @param index
     *            index at which the node will be added
     * @param value
     *            value to be added
     */
    @Override
    public void add(int index, E value) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }

        if (value == null) {
            throw new IllegalArgumentException();
        }

        Node<E> curr = first;

        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }

        curr.setNext(new Node<E>(value, curr.next()));
    }


    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }


    @Override
    public boolean contains(E arg0) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public E getEntry(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * Returns the size of the list as an int
     * 
     * @return size of list
     */
    @Override
    public int getLength() {
        return size;
    }


    /**
     * Checks if the list is empty
     * 
     * @return boolean for emptiness
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public E remove(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public E replace(int arg0, E arg1) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

}
