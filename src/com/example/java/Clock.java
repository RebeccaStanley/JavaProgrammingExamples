package com.example.java;

/**
 * This class implements the time of day in a Clock object
 * and implements the Cloneable interface to allow the
 * deep copying of Clock objects and the Comparable interface to
 * allow the comparison of two Clock objects
 * Created by vagrant on 12/5/15.
 */
public class Clock implements Cloneable, Comparable {
    private int hr;     //stores hours
    private int min;    //stores minutes
    private int sec;    //stores seconds

    /**
     * Default constructor
     */
    public Clock() {
        setTime(0, 0, 0);
    }

    /**
     * Constructor with parameters
     * @param hr
     * @param min
     * @param sec
     */
    public Clock(int hr, int min, int sec) {
        setTime(hr, min, sec);
    }


    /**
     * Copy constructor
     * The time is set according to the time of otherClock
     * @param otherClock
     */
    public Clock(Clock otherClock){
        setTime(otherClock.hr, otherClock.min, otherClock.sec );
    }

    /**
     * Method clone
     * Postcondition: Returns a reference of the copy of the object's data
     * @return
     */
    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

    /**
     * Method compareTo
     * Allows the values of two Clock objects to be properly compared
     * in the context of clocks and time
     * @param otherClock
     * @return
     */
    public int compareTo(Object otherClock){
        Clock temp = (Clock) otherClock;

        int hrDiff = hr - temp.hr;

        if (hrDiff != 0) return hrDiff;

        int minDiff = min - temp.min;

        if (minDiff != 0) return minDiff;

        return sec - temp.sec;
    }

    /**
     * method to set the time
     * @param hours
     * @param minutes
     * @param seconds
     */
    public void setTime(int hours, int minutes, int seconds){
        if (0 <= hours && hours < 24){
            hr = hours;
        }else{
            hr = 0;
        }

        if (0 <= minutes && minutes < 60){
            min = minutes;
        }else{
            min = 0;
        }

        if (0 <= seconds && seconds < 60){
            sec = seconds;
        }else{
            sec = 0;
        }
    }

    public int getHr() {
        return hr;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    /**
     * Method to increment the time by one second
     * Postcondition: The time is incremented by one second.
     * If the before-increment time is 23:59:59, the time
     * is reset to 00:00:00
     */
    public void incrementSeconds(){
        sec++;

        if (sec > 59){
            sec = 0;
            incrementMinutes();
        }

    }

    /**
     * Method to increment the time by one minute
     * Postcondition: The time is incremented by one minute.
     * If the before-increment time is 23:59:53, the time
     * is reset to 00:00:53
     */
    public void incrementMinutes(){
        min++;

        if (min > 59){
            min = 0;
            incrementHours();
        }

    }

    /**
     * Method to increment the time by one hour
     * Postcondition: The time is incremented by one hour.
     * If the before-increment time is 23:45:21, the time
     * is reset to 00:45:21
     */
    public void incrementHours(){
        hr++;

        if (hr > 23){
            hr = 0;
        }

    }

    /**
     * Method to compare two times
     * @param otherClock
     * @return
     */
    public boolean equals(Object otherClock){
        Clock temp = (Clock) otherClock;

        return (hr == temp.hr && min == temp.min && sec == temp.sec);
    }

    /**
     * Override the toString method to return the time in a well-formatted string
     * @return
     */
    public String toString(){
        String str = "";

        if (hr < 10){
            str = "0";
        }

        str += hr + ":";

        if (min < 10){
            str += "0";
        }

        str += min + ":";

        if (sec < 10 ){
            str += "0";
        }

        str += sec;

        return str;
    }

    //test
    public static void main (String args[]){
        /*
        Clock myClock = new Clock(5, 4, 30);
        System.out.println("myClock = " + myClock);

        Clock tempClock = (Clock) myClock.clone();
        System.out.println("tempClock = " + tempClock);

        if (myClock == tempClock){
            System.out.println("myClock and tempClock refer to the same object");
        }else{
            System.out.println("myClock and tempClock do not refer to the same object");
        }

        myClock.setTime(12, 28, 33);

        System.out.println("After changing the time, myClock: " + myClock);

        System.out.println("tempClock: " + tempClock);
        */

        Clock myClock = new Clock(3, 8, 22);
        Clock yourClock = new Clock(13,5,18);
        Clock tempClock = new Clock(3,8,22);

        System.out.println("myClock = " + myClock);
        System.out.println("yourClock = " + yourClock);
        System.out.println("tempClock = " + tempClock);

        if (myClock.compareTo(yourClock) == 0){
            System.out.println("The time of myClock is the same as the time of yourClock");
        }else if(myClock.compareTo(yourClock) < 0){
            System.out.println("The time of myClock is less than the time of yourClock");
        }else{
            System.out.println("The time of myClock is greater than the time of yourClock");
        }

        if (myClock.compareTo(tempClock) == 0){
            System.out.println("The time of myClock is the same as the time of tempClock");
        }else if(myClock.compareTo(tempClock) < 0){
            System.out.println("The time of myClock is less than the time of tempClock");
        }else{
            System.out.println("The time of myClock is greater than the time of tempClock");
        }

    }

}
