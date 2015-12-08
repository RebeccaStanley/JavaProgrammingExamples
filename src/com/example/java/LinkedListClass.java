package com.example.java;

import java.util.NoSuchElementException;

/**
 *Abstract class to implement the basic operations on a Linked List.
 *
 */
public abstract class LinkedListClass<T> implements LinkedListADT<T>{

    protected LinkedListNode<T> first;  //variable to store the address of the first node of the list
    protected LinkedListNode<T> last;   //variable to store the address of the last node of the list
    protected int count;    //variable to store the number of nodes in the list

    /**
     * Default constructor
     * Initializes the list to an empty state
     */
    public LinkedListClass() {
        first = null;
        last = null;
        count = 0;
    }

    /**
     * Method to determine whether the list is empty
     *
     * @return Returns true if list is empty; false otherwise.
     */
    @Override
    public boolean isEmptyList() {
        return (first == null);
    }

    /**
     * Method to initialize the list to an empty state.
     */
    @Override
    public void initalizeList() {
        first = null;
        last = null;
        count = 0;
    }

    /**
     * Method to output the data contained in each node
     */
    @Override
    public void print() {
        LinkedListNode<T> current; //variable to traverse the list

        current = first;

        while (current != null){
            System.out.println(current + " ");
            current = current.link;
        }
    }

    /**
     * Method to return the number of nodes in the list.
     *
     * @return the number of nodes
     */
    @Override
    public int length() {
        return count;
    }

    /**
     * Method to return a reference of the object containing the data
     * of the first node of the list.
     *
     * @return The reference of the object that contains the info of the first node
     */
    @Override
    public T front() {
        return first.info;
    }

    /**
     * Method to return a reference of the object containing the data
     * of the last node in the list
     *
     * @return The reference of the object that contains the info of the last node
     */
    @Override
    public T back() {
        return last.info;
    }

    /**
     * Method to determine whether searchItem is in the list.
     *
     * @param searchItem
     * @return True if searchItem is found in the list; otherwise false.
     */
    public abstract boolean search(T searchItem);

    /**
     * Method to return an iterator of the list
     * @return
     */
    public LinkedListIterator<T> iterator(){
        return new LinkedListIterator<T>();
    }

    /**
     * Method to insert newItem at the beginning of the list
     *
     * @param newItem
     */
    public abstract void insertFirst(T newItem);
    /**
     * Method to insert newItem at the end of the list.
     *
     * @param newItem
     */
    public abstract void insertLast(T newItem);

    /**
     * Method to delete deleteItem from the list.
     *
     * @param deleteItem
     */
    public abstract void deleteNode(T deleteItem);

    /**
     * Method to clone the list. Note that this makes a shallow copy of the list; it clones only
     * the references in each node.
     * @return
     */
    public Object clone(){
        LinkedListClass<T> copy = null;

        try{
            copy = (LinkedListClass<T>) super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }

        //if the list is not empty, clone each node of the list
        if (first != null){
            //clone the first node
            copy.first = (LinkedListNode<T>) first.clone();
            copy.last = copy.first;

            LinkedListNode<T> current;

            if (first != null){
                current = first.link;
            }else{
                current = null;
            }

            //clone the remaining nodes of the list
            while (current != null){
                copy.last.link = (LinkedListNode<T>) current.clone();
                copy.last = copy.last.link;
                current = current.link;
            }

        }

        return copy;
    }

    /**
     * Inner class of LinkedListClass, used to define the Linked List nodes
     * Created by vagrant on 12/8/15.
     */
    protected class LinkedListNode<T> implements Cloneable {

        public T info;  //reference variable to store the data
        public LinkedListNode<T> link;  //reference variable to store the reference of the next node

        /**
         * Default constructor
         */
        public LinkedListNode() {
            info = null;
            link = null;
        }

        /**
         * Constructor with parameters.
         * This method sets info pointing to the object to which elem points and link is set to point to
         * the object to which ptr points.
         * This constructor can be used to create a node and insert the node before a given node in the list.
         *
         * @param elem
         * @param ptr
         */
        public LinkedListNode(T elem, LinkedListNode<T> ptr) {
            this.info = elem;
            this.link = ptr;
        }

        /**
         * Returns a copy of objects data.
         * This method clones only the references stored in the node. The objects that the
         * nodes point to are not cloned
         *
         * @return
         */
        @Override
        public Object clone() {
            LinkedListNode<T> copy = null;

            try {
                copy = (LinkedListNode<T>) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }

            return copy;
        }

        /**
         * Method to return the info as a String
         *
         * @return
         */
        @Override
        public String toString() {
            return info.toString();
        }

    }

    /**
     * Inner class used to create iterators for traversing the Linked List
     * @param <T>
     */
    protected class LinkedListIterator<T>{
        protected LinkedListNode<T> current;    //variable to point to the current node in the list
        protected LinkedListNode<T> previous;   //variable to point to the node before the current node

        /**
         * Default constructor
         * Sets current to point to the first node in the list and sets previous to null
         */
        public LinkedListIterator() {
            current = (LinkedListNode<T>) first;
            previous = null;
        }

        /**
         * Method to reset the iterator to the first node in the list
         *
         */
        public void reset(){
            current = (LinkedListNode<T>) first;
            previous = null;
        }

        /**
         * Method to return a reference of the info of the current node in teh list
         * and to advance interator to the next node
         * @return
         */
        public T next(){
            if (!hasNext()){
                throw new NoSuchElementException();
            }

            LinkedListNode<T> temp = current;
            previous = current;
            current = current.link;

            return temp.info;
        }

        /**
         * Method to determine whether there is a next element in the list
         * @return True if there is a next node in the list; otherwise false
         */
        public boolean hasNext(){
            return (current != null);
        }

        /**
         * Method to remove the node currently pointed to by the iterator
         */
        public void remove(){
            if (current == null){
                throw new NoSuchElementException();
            }

            if (current == first){
                first = first.link;
                current = (LinkedListNode<T>) first;
                previous = null;

                if (first == null){
                    last = null;
                }
            }else{
                previous.link = current.link;

                if (current == last){
                    last = first;

                    while (last.link != null){
                        last = last.link;
                    }
                }
                current = current.link;
            }
            count--;
        }

        /**
         * Method to return the info as a String
         * @return
         */
        public String toString(){
            return current.info.toString();
        }
    }
}
