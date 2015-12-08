package com.example.java;

/**
 * Class derived from the LinkedListClass to implement operations required for an unordered linked list.
 * Created by vagrant on 12/8/15.
 */
public class UnorderedLinkedList<T> extends LinkedListClass<T> {

    /**
     * Default constructor
     */
    public UnorderedLinkedList() {

    }

    /**
     * Method to determine whether searchItem is in the list.
     *
     * @param searchItem
     * @return True if searchItem is found in the list; otherwise false.
     */
    @Override
    public boolean search(T searchItem) {
        LinkedListNode<T> current;  //variable to traverse the list
        boolean found;

        current = first;    //start at the beginning of the list
        found = false;  //set found to false

        while (current != null && !found){
            if (current.info.equals(searchItem)){
                found = true;
            }else{
                current = current.link; //move to the next node
            }
        }

        return found;
    }

    /**
     * Method to insert newItem at the beginning of the list
     *
     * @param newItem
     */
    @Override
    public void insertFirst(T newItem) {
        LinkedListNode<T> newNode;  //variable to create the new node
        newNode = new LinkedListNode<T>(newItem, first);    //create and insert the newNode before first
        first = newNode;

        if (last == null){  //if the list was empty, newNode is also the last node in the list
            last = newNode;
        }

        count++;    //increment count
    }

    /**
     * Method to insert newItem at the end of the list.
     *
     * @param newItem
     */
    @Override
    public void insertLast(T newItem) {
        LinkedListNode<T> newNode;  //variable to create the new node
        newNode = new LinkedListNode<T>(newItem, first);    //create and insert the newNode before first

        if (first == null){  //if the list is empty, newNode is both the first and last node
            first = newNode;
            last = newNode;
        }else{
            last.link = newNode;    //insert new node after last
            last = newNode;     //set last to point to the actual last node
        }

        count++;    //increment count
    }

    /**
     * Method to delete deleteItem from the list.
     *
     * @param deleteItem
     */
    @Override
    public void deleteNode(T deleteItem) {
        LinkedListNode<T> current;  //variable to traverse the list
        LinkedListNode<T> trailCurrent; //variable just before current
        boolean found;

        if (first == null){
            System.err.println("Cannot delete from an empty list.");
        }else{
            if (first.info.equals(deleteItem)){
                first = first.link;

                if (first == null){ //the list only had one node
                    last = null;
                }

                count--;

            }else{
                //search the list for the given info
                found = false;
                trailCurrent = first;
                current = first.link;

                while (current != null && !found){
                    if (current.info.equals(deleteItem)){
                        found = true;
                    }else{
                        trailCurrent = current;
                        current = current.link;
                    }
                }

                if (found){ //the node was in the list, delete it
                    count--;
                    trailCurrent.link = current.link;

                    if (last == current){   //node to be deleted was the last node
                        last = trailCurrent;    //update the value of last
                    }
                }else{
                    System.out.println("Item to be deleted is not in the list.");
                }
            }
        }
    }
}
