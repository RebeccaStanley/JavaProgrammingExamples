package com.example.java;

/**
 * Recursive definition: A definition in which something is defined in terms of a smaller version of itself
 * 1. Every recursive definition must have one (or more) base cases.
 * 2. The general case must eventually be reduced to a base case.
 * 3. The base case stops the recursion.
 * Created by vagrant on 12/5/15.
 */
public class Recursion {

   /**
     * An example of a recursive method to find the value of the factorial of an integer where
    * 0! = 1;
    * n! = n x (n - 1)! if n > 0
     * @param num
     * @return
     */
    public static int fact (int num){
        if (num == 0){
            return 1;
        }    else{
            return num * fact(num -1);
        }
    }

    /**
     * Recursive method to find the largest integer in an array
     * @param list
     * @param lowerIndex
     * @param upperIndex
     * @return
     */
    public static int largest(int[] list, int lowerIndex, int upperIndex){
        int max;

        if (lowerIndex == upperIndex){
            return list[lowerIndex]; //the size of the list is 1

        }else{
            max = largest(list, lowerIndex + 1, upperIndex);
            if (list[lowerIndex] >= max){
                return list[lowerIndex];
            }else{
                return max;
            }
        }
    }

    /**
     * Recursive method to determine the specified Fibonacci number in the sequence
     * @param a - the first number in the sequence
     * @param b - the second number in the sequence
     * @param n - the Fibonacci number we want to determine, whose first number is a and second number is b
     * @return
     */
    public static int rFibNum (int a, int b, int n){
        if (n == 1){
            return a;
        }else if (n == 2){
            return b;
        }else{
            return rFibNum(a, b, n-1) + rFibNum(a, b, n-2);
        }
    }


}
