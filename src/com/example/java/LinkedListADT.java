package com.example.java;

/**
 * Interface that describes the basic operations of a Linked List as an abstract data type (ADT)
 * Created by vagrant on 12/8/15.
 */
public interface LinkedListADT<T> extends Cloneable {

    /**
     * Returns a copy of objects data
     * This method clones only the references stored in each node of the list.
     * The objects that the list nodes point to are not cloned.
     * @return
     */
    public Object clone();

    /**
     * Method to determine whether the list is empty
     * @return Returns true if list is empty; false otherwise.
     */
    public boolean isEmptyList();

    /**
     * Method to initialize the list to an empty state.
     */
    public void initalizeList();

    /**
     * Method to output the data contained in each node
     */
    public void print();

    /**
     * Method to return the number of nodes in the list.
     * @return the number of nodes
     */
    public int length();

    /**
     * Method to return a reference of the object containing the data
     * of the first node of the list.
     * @return The reference of the object that contains the info of the first node
     */
    public T front();

    /**
     * Method to return a reference of the object containing the data
     * of the last node in the list
     * @return The reference of the object that contains the info of the last node
     */
    public T back();

    /**
     * Method to determine whether searchItem is in the list.
     * @param searchItem
     * @return True if searchItem is found in the list; otherwise false.
     */
    public boolean search(T searchItem);

    /**
     * Method to insert newItem at the beginning of the list
     * @param newItem
     */
    public void insertFirst(T newItem);

    /**
     * Method to insert newItem at the end of the list.
     * @param newItem
     */
    public void insertLast(T newItem);

    /**
     * Method to delete deleteItem from the list.
     * @param deleteItem
     */
    public void deleteNode(T deleteItem);
}
