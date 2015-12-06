package com.example.java;

/**
 * Generic method to find the larger of two objects of any data type
 * (Integer, String, Double, etc.) by EXTENDING the Comparable interface
 * Created by vagrant on 12/6/15.
 */
public class GenericMethodLarger {

    public static void main(String args[]){
        Integer x, y;

        x = 45;
        y = 50;

        System.out.println("larger(x, y) = " + larger(x, y));
        System.out.println("larger(54, larger(13, 45)) = " + larger(54, larger(13, 45)));
        System.out.println("larger(58.78, larger(89.90, 44.34)) = " + larger(58.78, larger(89.90, 44.34)));
        System.out.println("larger(\"Gym\", larger(\"Hi\", \"Here\" = " + larger("Gym", larger("Hi", "Here")));

        Clock myClock = new Clock (12, 34, 56);
        Clock yourClock = new Clock(8, 21, 45);

        System.out.println("larger(myClock, youClock) = " + larger(myClock, yourClock));
        System.out.println("larger(new Clock(6, 12, 34), larger(new Clock(18, 13, 44), new Clock(11, 44, 11))) = " +
                larger(new Clock(6, 12, 34), larger(new Clock(18, 13, 44), new Clock(11, 44, 11))));
    }

    /**
     * Generic method to find the larger of two parameters
     * Since the method uses the compareTo method, the method should only
     * be allowed to be used on classes whose objects can be compared (i.e.
     * there may be classes that do not provide a definition for the compareTo method).
     * Hence the type parameter T must be restricted to those classes that DO provide a
     * definition for the compareTo method of the Comparable interface
     * @param x
     * @param y
     * @param <T> T refers to any type or class that impements the Comparable interface.
     *           The keyword "extends" is ALWAYS used when a type parameter bounds a parameter,
     *           regardless of whether the type parameter expends a class or an interface.
     * @return
     */
    public static <T extends Comparable<T>> T larger(T x, T y){
        if (x.compareTo(y) >= 0){
            return x;
        }else{
            return y;
        }
    }
}
