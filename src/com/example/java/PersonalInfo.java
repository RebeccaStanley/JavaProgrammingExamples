package com.example.java;

/**
 * This class implements the attributes required to store personal info in a PersonalInfo object
 * and implements the Cloneable interface to allow the
 * deep copying of PersonalInfo objects and the Comparable interface to
 * allow the comparison of two PersonalInfo objects
 * Created by vagrant on 12/6/15.
 */
public class PersonalInfo implements Cloneable, Comparable {
    private Person name;
    private Date bDay;
    private int personID;

    /**
     * Default constructor
     */
    public PersonalInfo() {
        name = new Person();
        bDay = new Date();
        personID = 0;
    }

    /**
     * Constructor with parameters
     * Instance variables are set according to the parameters
     * @param name
     * @param bDay
     * @param personID
     */
    public PersonalInfo(Person name, Date bDay, int personID) {
        this.name = name;
        this.bDay = bDay;
        this.personID = personID;
    }

    /**
     * Constructor with parameters
     * Instance variables are set according to the parameters
     * @param first
     * @param last
     * @param month
     * @param day
     * @param year
     * @param ID
     */
    public PersonalInfo(String first, String last, int month, int day, int year, int ID) {
        name = new Person(first, last);
        bDay = new Date(month, day, year);
        personID = ID;
    }

    /**
     * Overrides the clone method of Cloneable to return a reference to
     * a copy of the Object's data.
     * In this case, since PersonalInfo contains reference variables of type
     * Person and Date which are mutable objects, the clone method must explicitly
     * clone the objects name and bDay after making a bit-by-bit copy of the PersonalInfo
     * object's data in storage
     * @return
     */
    public Object clone(){
        try{
            PersonalInfo copy = (PersonalInfo) super.clone();
            copy.bDay = (Date) bDay.clone();    //explicitly clone the object bDay
            copy.name = (Person) name.clone();  //explicitly clone the object name

            return copy;
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

    /**
     * Method to set the personal information.
     * Instance variables are set according to the parameters
     * @param first
     * @param last
     * @param month
     * @param day
     * @param year
     * @param ID
     */
    public void setPersonalInfo(String first, String last, int month, int day, int year, int ID){
        name.setName(first, last);
        bDay.setDate(month, day, year);
        personID = ID;
    }

    /**
     * Overrides the toString method of the Object class
     * @return
     */
    public String toString(){
        return ("Name: " + name.toString() + "\n" +
            "Date of birth: " + bDay.toString() + "\n" +
            "Personal ID: " + personID);
    }

    /**
     * Method to compare two PersonalInfo objects in a meaningful way
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        PersonalInfo temp = (PersonalInfo) o;
        int retValue;

        retValue = personID - temp.personID;

        if (retValue == 0) {
            retValue = name.compareTo(temp.name);
        }

        if (retValue == 0) {
            retValue = bDay.compareTo(temp.bDay);
        }

        return retValue;

    }

    //Test
    public static void main(String args[]){
        PersonalInfo student = new PersonalInfo("William", "Jordan", 8, 24, 1963, 555238911);

        System.out.println("Student: " + student);
        System.out.println();

        PersonalInfo temp = (PersonalInfo)student.clone();

        System.out.println("Temp: " + temp);
        System.out.println();

        student.setPersonalInfo("Mary", "Smith", 11,22,1953,888434343);

        System.out.println("Student: " + student);
        System.out.println();
        System.out.println("Temp: " + temp);

        if (student.compareTo(temp) == 0){
            System.out.println("student and temp have the same personal info");
        }else{
            System.out.println("student and temp do not have the same name");
        }
    }
}
