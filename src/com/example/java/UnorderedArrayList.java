package com.example.java;

import java.util.Scanner;

/**
 * Class derived from ArrayListClass implementing methods to deal with
 * search, insert, remove for unordered array
 * Created by vagrant on 12/6/15.
 */
public class UnorderedArrayList<T> extends ArrayListClass<T> {

    public UnorderedArrayList(int size) {
        super(size);
    }

    public UnorderedArrayList() {
        super();
    }

    /**
     * Method to insert insertItem in the list at the position specified by location.
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
            for (int i = length; i > location; i--){
                list[i] = list[i - 1]; //move the elements down
            }
            list[location] = insertItem;
            length++;   //increment the length
        }
    }

    /**
     * Method to insert insertItem at the end of the list
     * @param insertItem
     */
    @Override
    public void insertEnd(T insertItem) {
        if(length >= maxSize){
            System.err.println("Cannot insert in a full list.");
        }else {
            list[length] = insertItem;  //insert the item at the end
            length++;   //increment the length
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
            list[location] = repItem;
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
            if (list[loc].equals(searchItem)){
                found = true;
                break;
            }
        }

        if (found) {
            return loc;
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
        int loc;
        if (length == 0) {
            System.err.println("Cannot delete from an empty list.");
        }else{
            loc = seqSearch(removeItem);

            if(loc != -1){
                removeAt(loc);
            }else{
                System.err.println("The item to de deleted is not in the list.");
            }
        }
    }
    
    //test  
    public static void main(String args[]){
        Scanner console = new Scanner(System.in);
        
       // UnorderedArrayList<Double> numList = new UnorderedArrayList<Double>(50);
        //Double num;
//        System.out.println("Enter 8 numbers: ");
//        for (int i = 0; i < 8; i++){
//            num = console.nextDouble();
//            numList.insertEnd(num);
//        }
//
//        System.out.println();
//        System.out.println("The list you entered is: ");
//        numList.print();
//
//        System.out.println("Enter the number to be deleted: " );
//        num = console.nextDouble();
//        System.out.println();
//
//        numList.remove(num);
//        System.out.println("After removing " + num + ", the list is: ");
//        numList.print();
//
//        System.out.println("Enter the position of the number to be deleted: ");
//        int position = console.nextInt();
//        System.out.println();
//
//        numList.removeAt(position);
//        System.out.println("After removing the element at position " + position + ", numList: ");
//        numList.print();
//
//        System.out.println("Enter the search item: ");
//        num = console.nextDouble();
//        System.out.println();
//
//        if (numList.seqSearch(num) != -1){
//            System.out.println("Item found in the list");
//        }else{
//            System.out.println("Item not found in the List.");
//        }

//        UnorderedArrayList<Double> temp;
//
//        System.out.print("Enter 3 numbers: ");
//        for (int i = 0; i < 3; i++){
//            num = console.nextDouble();
//            numList.insertEnd(num);
//        }
//
//        System.out.println();
//        System.out.println("The list you entered is: ");
//        numList.print();
//
//        temp = (UnorderedArrayList<Double>) numList.clone();
//        System.out.println("Temp: ");
//        temp.print();
//
//        temp.replaceAt(0, 58.39);
//
//        System.out.println("numList: ");
//        numList.print();
//
//        System.out.println("Temp: ");
//        temp.print();

        UnorderedArrayList<Clock> clockList = new UnorderedArrayList<Clock>(50);
        UnorderedArrayList<Clock> temp1;
        UnorderedArrayList<Clock> temp2;

        clockList.insertEnd(new Clock(12,5,32));
        clockList.insertEnd(new Clock(5,8,22));
        clockList.insertEnd(new Clock(8, 35, 11));

        System.out.println("clockList: ");
        clockList.print();

        temp1 = (UnorderedArrayList<Clock>) clockList.clone();
        temp2 = copyList(clockList);

        Clock c1;
        c1 = temp1.retrieveAt(0);
        c1.setTime(15,32,44);
        c1 = temp2.retrieveAt(0);
        c1.setTime(10,8,55);

        System.out.println("cloclList: ");
        clockList.print();

        System.out.println("temp1: ");
        temp1.print();

        System.out.println("temp2: ");
        temp2.print();
    }

    public static UnorderedArrayList<Clock> copyList (UnorderedArrayList<Clock> otherList){
        UnorderedArrayList<Clock> tempList = new UnorderedArrayList<Clock>(otherList.maxListSize());

        Clock c1;

        for (int k = 0; k < otherList.listSize(); k++){
            c1 = otherList.retrieveAt(k);
            tempList.insertEnd((Clock)c1.clone());
        }

        return tempList;
    }
}
