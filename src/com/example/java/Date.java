package com.example.java;

/**
* This class implements the attributes of a date in a Date object
* and implements the Cloneable interface to allow the
* deep copying of Date objects and the Comparable interface to
* allow the comparison of two Date objects
 * Created by vagrant on 12/6/15.
**/
public class Date implements Cloneable, Comparable {
    private int dMonth;
    private int dDay;
    private int dYear;

    /**
     * Default constructor
     */
    public Date() {
        dMonth = 1;
        dDay = 1;
        dYear = 1900;
    }

    /**
     * Constructor with parameters
     * Instance variables are set according to the parameters
     * @param dMonth
     * @param dDay
     * @param dYear
     */
    public Date(int dMonth, int dDay, int dYear) {
        this.dMonth = dMonth;
        this.dDay = dDay;
        this.dYear = dYear;
    }

    /**
     * Overrides the clone method of Cloneable to return a reference to
     * a copy of the Object's data
     * @return
     */
    public Object clone(){
        try{
            return super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

    public int getdMonth() {
        return dMonth;
    }

    public int getdDay() {
        return dDay;
    }

    public int getdYear() {
        return dYear;
    }

    /**
     * Method to set the date
     * @param month
     * @param day
     * @param year
     */
    public void setDate(int month, int day, int year){
        this.dMonth = month;
        this.dDay = day;
        this.dYear = year;
    }

    /**
     * Overrides the toString method of the Object class to
     * return a well formatted string of the Date object
     * @return
     */
    public String toString(){
        return (dMonth + "-" + dDay + "-" + dYear);
    }

    /**
     * Method to compare two Date objects in a meaningful way
     * @param otherDate
     * @return
     */
    @Override
    public int compareTo(Object otherDate) {
        Date temp = (Date) otherDate;

        int yrDiff = dYear - temp.dYear;

        if (yrDiff != 0) return yrDiff;

        int monthDiff = dMonth = temp.dMonth;

        if (monthDiff != 0) return monthDiff;

        return dDay - temp.dDay;
    }
}
