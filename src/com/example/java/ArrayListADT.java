package com.example.java;

/**
 * An example of an implementation of a generic interface that
 * performs the functions of an array list
 * Created by vagrant on 12/6/15.
 */
public interface ArrayListADT<T> extends Cloneable{

    /**
     * Method to determine whether the list is empty
     * @return True if list is empty, otherwise returns false
     */
    public boolean isEmpty();

    /**
     * Method to determine whether the list is full
     * @return True if list is full, otherwise returns false
     */
    public boolean isFull();

    /**
     *  Method to return the number of elements in the list
     * @return the value of the length
     */
    public int listSize();

    /**
     * Method to return the maximum size of the list
     * @return the maximum number of elements that can be inserted into the list
     */
    public int maxListSize();

    /**
     * Method to output the elements of the list
     */
    public void print();

    /**
     * Method to clone only the references stores in the array. The objects that the
     * array references point to are not cloned
     * @return a copy of objects data in store
     */
    public Object clone();

    /**
     * Method to determine whether item is the same as the item in the list at the position
     * specified by the location.
     * @param location
     * @param item
     * @return Trus if the element in the list at the specified position is the same as item, otherwise
     * return false
     */
    public boolean isItemAtEqual(int location, T item);

    /**
     * Method to insert insertItem in the list at the position specified by location
     * @param location
     * @param insertItem
     * @return Starting at location, the elements of the list are shifted to make room
     * for insterItem; insertItem is inserted at the position specified by location and the length
     * of the list is incremented by 1. If the list is full or location is out of range, an appropriate
     * message is output and false is returned.
     */
    public boolean insertAt(int location, T insertItem);

    /**
     * Method to insert insertItem at the end of the list
     * @param insertItem
     */
    public void insertEnd(T insertItem);

    /**
     * Method to remove the item from the list at the position specified by location
     * @param location
     */
    public void removeAt(int location);

    /**
     * Method to retrieve the element from the list at the position specified by the location
     * @param location
     * @return A reference of the element at the position specified by location is returned.
     * If location is out of range, an appropriate message is output and null is returned.
     */
    public T retrieveAt(int location);

    /**
     * Method to replace the element in the list at the position specified by location with repItem
     * @param location
     * @param repItem
     */
    public void replaceAt(int location, T repItem);

    /**
     * Method to remove all the elements from the list. The length of the list is then 0.
     */
    public void clearList();

    /**
     * Method to determine whether searchItem is in the list.
     * @param searchItem
     * @return If searchitem is found, returns the location in the array where searchItem is found;
     * otherwise returns -1
     */
    public int seqSearch(T searchItem);

    /**
     * Method to remove an item from the list. If removeItem is found in the list, it is removed from
     * the list and length is decremented by 1.
     * @param removeItem
     */
    public void remove(T removeItem);

}
