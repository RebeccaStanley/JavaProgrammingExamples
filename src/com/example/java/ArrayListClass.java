package com.example.java;

/**
 * An example of an abstract class that implements some of the methods
 * of the generic interface ArrayListADT
 * Created by vagrant on 12/6/15.
 */
public abstract class ArrayListClass<T> implements ArrayListADT<T>, Cloneable {

    protected int length; //stores the length of the list
    protected int maxSize;  // stores the maximum size of the list
    protected T[] list;     //array to hold the list elements

    /**
     * Default constructor.
     * Creates an array of size 100
     */
    public ArrayListClass() {
        this.maxSize = 100;
        this.length = 0;
        list = (T[]) new Object[maxSize];
    }

    /**
     * Constructor with a parameter. Creates an array of the size specified by the parameter
     * @param size
     */
    public ArrayListClass(int size) {
        if (size <= 0){
            System.err.println("The array size must be positive. " +
                "Creating an array of size 100. ");
            maxSize = 100;
        }else{
            maxSize = size;
        }

        length = 0;
        list = (T[]) new Object[maxSize];

    }

    public boolean isEmpty(){
        return (length == 0);
    }

    public boolean isFull(){
        return (length == maxSize);
    }

    public int listSize(){
        return length;
    }

    public int maxListSize(){
        return maxSize;
    }

    public void print(){
        for (int i = 0; i < length; i++){
            System.out.println(list[i]);
        }
        System.out.println();
    }

    public Object clone(){
        ArrayListClass <T> copy;

        try{
            copy = (ArrayListClass<T>)super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }

        copy.list = (T[]) list.clone();

        return copy;
    }

    public boolean isItemAtEqual(int location, T item){

    }

    public abstract void insertAt(int location, T insertItem);

    public abstract void insertEnd(T insertItem);

    public void removeAt(int location){

    }

    public T retrieveAt(int location){

    }

    public abstract void replaceAt(int location, T repItem);

    public void clearList(){



    }

    public abstract int seqSearch(T searchItem);

    public abstract void remove(T removeItem);

}
