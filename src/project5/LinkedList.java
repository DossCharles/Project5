// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who do.
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
public class LinkedList<E> implements ListInterface<E>{

    private Node<E> first;
    
    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
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
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Sets the node before this one
         *
         * @param n
         *            the node before this one
         */
        public void setPrevious(Node<E> n) {
            previous = n;
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
         * Gets the node before this one
         *
         * @return the node before this one
         */
        public Node<E> previous() {
            return previous;
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


    @Override
    public void add(E arg0) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void add(int arg0, E arg1) {
        // TODO Auto-generated method stub
        
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


    @Override
    public int getLength() {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
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
