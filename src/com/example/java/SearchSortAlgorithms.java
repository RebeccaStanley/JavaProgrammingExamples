package com.example.java;

import java.util.*;

/**
 * Class implementing the SearchSortADT interface providing definitions of the search
 * and sort algorithms.
 * Created by vagrant on 12/9/15.
 */
public class SearchSortAlgorithms<T> implements SearchSortADT<T>{

    /**
     * Sequential search algorithm
     * Performance is not great. It has a linear growth rate and a big O notation of O(n)
     * @param list
     * @param length
     * @param searchItem
     * @return The location of the searchItem; otherwise -1
     */
    @Override
    public int seqSearch(T[] list, int length, T searchItem) {
        int loc;
        boolean found = false;

        for (loc = 0; loc < length; loc++){
            if (list[loc].equals(searchItem)){
                found = true;
                break;
            }
        }

        if (found){
            return loc;
        }else{
            return -1;
        }
    }

    /**
     * Binary search algorithm. The list must be sorted!
     * Uses the "divide and conquer!" technique to search the list.
     * Performance is better but the list has to be sorted first if not already, which adds overhead.
     * It has a slower growth rate then the sequential search and has a big O notation of O(log2n)
     * @param length
     * @param searchItem
     * @return The location of the searchItem; otherwise -1
     */
    @Override
    public int binarySearch(T[] list, int length, T searchItem) {
        int first = 0;
        int last = length - 1;
        int mid = -1;
        boolean found = false;

        while (first <= last && !found){
            mid = (first + last) / 2;
            Comparable<T> compElem = (Comparable<T>) list[mid];

            if (compElem.compareTo(searchItem) == 0){
                found = true;
            }else{
                if (compElem.compareTo(searchItem) > 0){
                    last = mid - 1;
                }else{
                    first = mid + 1;
                }
            }
        }

        if (found){
            return mid;
        }else{
            return -1;
        }
    }

    /**
     * Bubble sort algorithm. Returns list of objects in ascending order.
     * "Compare and swap". In a series of n-1 iterations, elements are compared and smaller
     * elements are moved to the top of the list.
     * Performance is not great. The growth rate increases rapidly with the size of the problem
     * (the growth rate quadruples as the problem size doubles).
     * It has a big O notation of O(n^2)
     * @param list
     * @param length
     */
    @Override
    public void bubbleSort(T[] list, int length) {
        for (int iteration = 1; iteration < length; iteration++){

            for (int index = 0; index < length - iteration; index++){
                Comparable<T> compElem = (Comparable<T>) list[index];

                if (compElem.compareTo(list[index + 1]) > 0){
                    T temp = list[index];
                    list[index] = list[index + 1];
                    list[index + 1] = temp;
                }
            }
        }
    }

    /**
     * Selection sort algorithm. Returns list of objects in ascending order.
     * Selection sort takes the smallest element in the unsorted portion of the list and moves
     * it to the top of the unsorted list. The first time it locates the smallest item in the
     * entire list, the second time it locates the smallest item in the list starting from the
     * second element in the list, and so on.
     * Again, performance is not great. The growth rate increases rapidly with the size of the problem
     * (the growth rate quadruples as the problem size doubles).
     * It has a big O notation of O(n^2)
     * @param list
     * @param length
     */
    @Override
    public void selectionSort(T[] list, int length) {
        for (int index = 0; index < length -1; index ++){
            int minIndex = minLocation(list, index, length-1);
            swap(list, index, minIndex);
        }
    }

    private int minLocation(T[] list, int first, int last){
        int minIndex= first;

        for (int loc = first + 1; loc <= last; loc++){
            Comparable<T> compElem = (Comparable<T>) list[loc];

            if (compElem.compareTo(list[minIndex]) < 0){
                minIndex = loc;
            }
        }

        return minIndex;
    }

    private void swap(T[] list, int first, int second){
        T temp;

        temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }

    /**
     * Insertion sort algorithm. Returns list of objects in ascending order.
     * This sort algorithm sorts the list by moving each element to its proper
     * place in the sorted portion of the list. The list is divided into two sublists:
     * sorted and unsorted. An index (firstOutOfOrder) is used to point to the
     * first element of the unsorted sublist (initially 1).
     * Again, performance is not great. The growth rate increases rapidly with the size of the problem
     * (the growth rate quadruples as the problem size doubles).
     * It has a big O notation of O(n^2)
     * @param list
     * @param length
     */
    @Override
    public void insertionSort(T[] list, int length) {
        for (int firstOutOfOrder = 1; firstOutOfOrder< length; firstOutOfOrder++){
            Comparable<T> temp = (Comparable<T>) list[firstOutOfOrder];
            int location = firstOutOfOrder;

            do{
                list[location] = list[location - 1];
                location--;
            }while (location > 0 && temp.compareTo(list[location - 1]) < 0);

            list[location] = (T) temp;
        }
    }

    /**
     * Quick sort algorithm. Returns list of objects in ascending order.
     * This sort algorithm uses a divide-and-conquer technique to sort the list.
     * The list is split into two sublists (lowerSublist and upperSublist),
     * which are then sorted and combined into
     * one list in such a way that the combined list is sorted.
     * @param list
     * @param length
     */
    @Override
    public void quickSort(T[] list, int length) {

    }

    /**
     * Selection sort algorithm. Returns list of objects in ascending order.
     *
     * @param list
     * @param length
     */
    @Override
    public void heapSort(T[] list, int length) {

    }

    //Test
    public static void main(String args[]){
        //Test binarySearch
//        Integer[] intList = {2, 16, 34, 45, 53, 56, 69, 70, 75, 96};
//
//        SearchSortAlgorithms<Integer> intSearchObject = new SearchSortAlgorithms<Integer>();
//        int pos;
//
//        pos = intSearchObject.binarySearch(intList, intList.length, 45);
//
//        if (pos != -1){
//            System.out.println("45 found at position " + pos);
//        }else{
//            System.out.println("45 is not in intList");
//        }

        //Test bubbleSort
        Integer[] intList = {2, 56, 34, 25, 73, 46, 89, 10, 5, 16};

        SearchSortAlgorithms<Integer> intSortObject = new SearchSortAlgorithms<Integer>();

        System.out.println("List before sorting: ");
        print(intList, intList.length);

        intSortObject.bubbleSort(intList, intList.length);

        System.out.println("List after sorting: ");
        print(intList, intList.length);

//        List<Integer> arrayList = new ArrayList<Integer>();
//        Collections.sort(arrayList);


    }

    public static <T> void print(T[] list, int length){
        for (int i = 0; i < length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }


}
