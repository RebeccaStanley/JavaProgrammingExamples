package com.example.java;

/**
 * This class implements the attributes of a person in a Person object
 * and implements the Cloneable interface to allow the
 * deep copying of Person objects and the Comparable interface to
 * allow the comparison of two Person objects
 * Created by vagrant on 12/6/15.
 */
public class Person implements Cloneable, Comparable {

    private String firstName;
    private String lastName;

    /**
     * Default constructor
     */
    public Person() {
        firstName = "";
        lastName = "";
    }

    /**
     * Constructor with parameters
     * Instance variables are set according to the parameters
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Override the clone method of Cloneable to return a
     * reference of the copy of the object's data
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
     * Override the toString method of Object to return
     * a String relevant to the context of the person (first name
     * and last name)
     * @return
     */
    public String toString(){
        return firstName + " " + lastName;
    }

    /**
     * Method to set the first name and the last name
     * @param firstName
     * @param lastName
     */
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Method to compare two Person objects
     * @param otherPerson
     * @return
     */
    @Override
    public int compareTo(Object otherPerson) {
        Person temp = (Person) otherPerson;

        if (firstName.equals(temp.firstName) && (lastName.equals(temp.lastName))){
            return 0;
        }else if ((lastName.compareTo(temp.lastName) < 0) ||
                ((lastName.equals(temp.lastName) && (firstName.compareTo(temp.firstName) < 0)))){
            return -1;
        }else{
            return 1;
        }
    }

    public static void main(String args[]){
        Person p1 = new Person("Mary", "Smith");
        Person p2 = new Person("Jessica", "Jones");

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);

        if (p1.compareTo(p2) == 0){
            System.out.println("p1 and p2 have the same name");
        }else{
            System.out.println("p1 and p2 do not have the same name");
        }
    }
}

