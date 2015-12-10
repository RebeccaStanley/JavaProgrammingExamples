package com.example.java;

import java.util.Scanner;

/**
 * Class derived from ArrayListClass implementing methods to deal with
 * search, insert, remove for unordered array
 * Created by vagrant on 12/6/15.
 */
public class OrderedArrayList<T> extends ArrayListClass<T>{
    /**
     * Default constructor.
     * Creates an array of size 100
     */
    public OrderedArrayList() {

    }

    /**
     * Constructor with a parameter. Creates an array of the size specified by the parameter
     *
     * @param size
     */
    public OrderedArrayList(int size) {
        super(size);
    }

    /**
     * Method to insert a new item in the list. The new item is inserted at the proper place
     * in the list and the length of the list is increased by 1. If the list is full, an appropriate
     * message is output.
     * @param insertItem
     */
    public void insert(T insertItem){
        int loc;
        boolean found = false;

        if (length == 0){   // list is empty
            list[length++] = insertItem;    //insert the item and increment the length
        }else if(length == maxSize){
            System.err.println("Cannot insert in a full list.");
        }else{
            for(loc = 0; loc < length; loc++){
                Comparable<T> temp = (Comparable<T>) list[loc];
                if (temp.compareTo(insertItem) >= 0){
                    found = true;
                    break;
                }
            }

            for (int i = length; i > loc; i--){
                list[i] = list[i - 1]; //move the elements down
            }

            list[loc] = insertItem; //insert item
            length++;   //increment the length
        }
    }

    /**
     * Method to insert insertItem in the list at the position specified by location.
     * In reality this method does not apply to an ordered list, but the definition must be provided since
     * it is an abstract method in the parent class.
     * @param location
     * @param insertItem
     */
    @Override
    public void insertAt(int location, T insertItem) {
        if (location < 0 || location >= maxSize){
            System.err.println("The position of the item to " +
                    "be inserted is out of range.");
        }else if(length >= maxSize){
            System.err.println("Cannot insert in a full list.");
        }else{
            System.out.println("This is a sorted list. Inserting at the proper place.");
            insert(insertItem);
        }
    }

    /**
     * Method to insert insertItem at the end of the list.
     * In reality this method does not apply to an ordered list, but the definition must be provided since
     * it is an abstract method in the parent class.
     * @param insertItem
     */
    @Override
    public void insertEnd(T insertItem) {
        if(length >= maxSize){
            System.err.println("Cannot insert in a full list.");
        }else {
            System.out.println("This is a sorted list. Inserting at the proper place.");
            insert(insertItem);
        }
    }

    /**
     * Method to replace the element in the list at the position specified by location with repItem
     * @param location
     * @param repItem
     */
    @Override
    public void replaceAt(int location, T repItem) {
        if (location < 0 || location >= length){
            System.err.println("The location of the item to be replaced is out of range.");
        }else{
            //in an ordered list, to replace an item at a specific position we must first remove the
            //item at the given position and then insert the item at its proper place in the list
            removeAt(location);
            insert(repItem);
        }
    }

    /**
     * Method to detemine whether searchItem is in the list.
     * @param searchItem
     * @return If searchItem is found, returns the location in the array; otherwise returns -1
     */
    @Override
    public int seqSearch(T searchItem) {
        int loc;
        boolean found = false;

        for (loc = 0; loc < length; loc++){
            //list[loc] is a reference of the Object type which we type cast to T. The Object class does not
            //contain the method compareTo, so a reference is created of type Comparable<T> and then we can
            //use the compareTo method of this.
            //NOTE this only works on objjects of classes that implement the interface Comparable
            //and provide an appropriate definition of the method compareTo
            Comparable<T> temp = (Comparable<T>)  list[loc];
            if (temp.compareTo(searchItem) >= 0) {
                found = true;
                break;
            }
        }

        if (found) {
            if (list[loc].equals(searchItem)){
                return loc;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    /**
     * Method to remove an item from the list
     * @param removeItem
     */
    @Override
    public void remove(T removeItem) {

    }

    public int binarySearch(T searchItem){
        SearchSortAlgorithms<T> searchObject = new SearchSortAlgorithms<T>();

        return searchObject.binarySearch(list, length, searchItem);
    }

    //TEST
    public static void main(String args[]){
        Scanner console= new Scanner(System.in);

        OrderedArrayList<Integer> intList = new OrderedArrayList<Integer>();
        Integer num;
        System.out.print("Enter 8 integers: ");

        for (int count = 0; count < 8; count++){
            num = console.nextInt();
            intList.insert(num);
        }

        System.out.println();
        System.out.println("intList: ");
        intList.print();

        System.out.print("Enter the search item: ");
        num = console.nextInt();
        System.out.println();

        int pos;

        pos = intList.binarySearch(num);

        if (pos != -1){
            System.out.println(num + " found at position " + pos);
        }else{
            System.out.println(num + " is not in intList");
        }
    }

}
