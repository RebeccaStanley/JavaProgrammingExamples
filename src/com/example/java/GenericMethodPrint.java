package com.example.java;

/**
 * Class to illustrate the definition of generic methods in Java
 * Created by vagrant on 12/6/15.
 */
public class GenericMethodPrint {

    public static void main(String args[]){
        Integer[] intList = {2, 13, 4, 18, 21, 11, 5, 10};
        Double[] numList = {12.0, 23.5, 4.6, 28.3, 11.85};
        String[] strList = {"Java", "Basic", "Perl", "Python", "C++"};
        Clock[] clockList = new Clock[3];

        clockList[0] =  new Clock(12, 5, 12);
        clockList[1] = new Clock(5, 8, 22);
        clockList[2] = new Clock(2, 16, 42);

        System.out.print("intList = ");
        print(intList);

        System.out.print("numList = ");
        print(numList);

        System.out.print("strList = ");
        print(strList);

        System.out.print("clockList = " );
        print(clockList);
    }

    public static <T> void print(T ... list){
        for (T elem: list){
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}
