package com.example.java;

/**
 * Generic interface that described various searching and sorting algorithms
 * Created by vagrant on 12/8/15.
 */
public interface SearchSortADT<T> {
    /**
     * Sequential search algorithm
     * @param list
     * @param length
     * @param searchItem
     * @return The location of the searchItem; otherwise -1
     */
    public int seqSearch(T[] list, int length, T searchItem);

    /**
     * Binary search algorithm. The list must be sorted!
     * @param list
     * @param length
     * @param searchItem
     * @return The location of the searchItem; otherwise -1
     */
    public int binarySearch(T[] list, int length, T searchItem);

    /**
     * Bubble sort algorithm. Returns list of objects in ascending order.
     * @param list
     * @param length
     */
    public void bubbleSort(T[] list, int length);

    /**
     * Selection sort algorithm. Returns list of objects in ascending order.
     * @param list
     * @param length
     */
    public void selectionSort(T[] list, int length);

    /**
     * Selection sort algorithm. Returns list of objects in ascending order.
     * @param list
     * @param length
     */
    public void insertionSort(T[] list, int length);

    /**
     * Selection sort algorithm. Returns list of objects in ascending order.
     * @param list
     * @param length
     */
    public void quickSort(T[] list, int length);

    /**
     * Selection sort algorithm. Returns list of objects in ascending order.
     * @param list
     * @param length
     */
    public void heapSort(T[] list, int length);
}
