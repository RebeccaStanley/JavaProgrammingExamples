package com.example.java;

import java.util.Scanner;

/**
 * Class to store the two components of a Linked List node.
 * Created by vagrant on 12/6/15.
 */
public class Node {
    public int info;
    public Node link;

    private static Scanner console = new Scanner(System.in);

    static Node buildListForward(){
        //Building a Linked List Forward adds new nodes to the end of the list
        Node first, last, newNode;
        int num;

        first = null;
        last = null;

        System.out.print("Enter integers for your Linked List ending with -999: ");
        num = console.nextInt();

        while (num != -999){

            newNode = new Node();   //allocate memory of the type Node and store the address of the allocated
                                    //memory in newNode;
            newNode.info = num;     //copy the value of num into the info field of newNode
            newNode.link = null;    //initialize the link field of newNode to null;

            //if first is null, the list is empty; make first and last point to newNode
            if (first == null){
                first = newNode;
                last = newNode;
            }else{
                last.link = new Node();   //insert newNode at the end of the list
                last = newNode;         //set last so that it points to the actual last node in the list
            }

            num = console.nextInt();

        }

        return first;
    }

    static Node buildListBackward(){
        //Building a Linked List Backward has the advantage of only needing two reference variables,
        //since the new node is always inserted at the beginning of the list so the reference variable
        //"last" is not needed.
        Node first, newNode;
        int num;

        first = null;

        System.out.print("Enter integers for your Linked List ending with -999: ");
        num = console.nextInt();

        while (num != -999){

            newNode = new Node();   //create a new Node
            newNode.info = num;     //copy the value of num into the info field of newNode
            newNode.link = first;    //put newNode at the beginning of the list

            first = newNode;    //update the head of the list

            num = console.nextInt();

        }

        return first;
    }

    public static void main (String args[]){


        Node head, current, q, newNode;
        head = new Node();
        //Head points to the first node in the linked list
        //The link of the last node is null

        //Head: the address of the first node
        //head.info: the information stored in the first node
        //head.link: the address of the next node in the linked list
        //head.link.info: the information stored in the second node
        //etc...


        //We traverse the linked list using a "current" reference variable of the same type as "Head"
        //current = head copies the value of head into current (i.e. the address of the first node
        //in the linked list
        //current.info: the information stored in the first node
        //current.link: the address of the next node in the linked list
        //current.link.info: the information stored in the second node
        //etc...

        current = head;
        while (current != null){
            //process current
            System.out.println(current.info + " ");
            current = current.link;
        }


        head = buildListForward();

        //node insertion
        newNode = new Node();   //creates a new node somewhere in memory and stores its adress in the newly created
                                //node newNode
        newNode.info = 50;      //stores 50 in the info field of the new node
        newNode.link = current.link;
        current.link = newNode;

        //deletion
        current.link = current.link.link; //delete the node after the one current is pointing to
        System.gc();    //you can run the garbage collector to reclaim the memory occupied by the deleted node


    }

}
