package com.example.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int test = 4;
        int list[] = new int[]{5, 10, 12, 8};
        int a = 2;
        int b = 3;
        int n = 5;


        //System.out.println(test + "! = " + Recursion.fact(4));
        //System.out.println("The largest number in the array is " + Recursion.largest(list, 0, 3));

        Scanner console = new Scanner(System.in);
        System.out.print(("Enter the first Fibonacci number: "));
        a = console.nextInt();
        System.out.println();
        System.out.print("Enter the second Fibonacci number: ");
        b = console.nextInt();
        System.out.println();
        System.out.print("Enter the position of the desired number in the Fibonacci sequence: ");
        n = console.nextInt();
        System.out.println();

        System.out.println("The " + n + "th Fibonacci number of the sequence " + a + ", " + b + " is: " +
            Recursion.rFibNum(a, b, n));
    }
}
