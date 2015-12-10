package com.example.java;

/**
 * Generic class to implement a binary search tree (BST)
 * In a BST, nodes are always added as a left child if the info is less than the parent
 * node and as a right child if the info is greater than the parent node, starting at the root
 * node and enforcing the 2-child limit of a binary tree.
 * Created by vagrant on 12/10/15.
 */
public class BinarySearchTree<T> extends BinaryTree<T> {

    BinaryTreeNode<T> root;

    public BinarySearchTree() {
    }

    /**
     * Method to determine whether searchItem is in the binary search tree.
     *
     * @param searchItem
     * @return Returns true if searchItem is found in the binary search tree; otherwise false.
     */
    @Override
    public boolean search(T searchItem) {
        BinaryTreeNode<T> current;
        boolean found = false;

        if (root == null){
            System.out.println("Cannot search an empty tree");
        }else{
            current = root;

            while (current != null && !found){
                Comparable<T> temp = (Comparable<T>) current.info;
                if (temp.compareTo(searchItem) == 0){
                    found = true;
                }else if (temp.compareTo(searchItem) > 0){
                    //searchItem is less than current; follow the lLink of current
                    current = current.lLink;
                }else{
                    //searchItem is greater than current; follow the rLink of current
                    current = current.rLink;
                }
            }
        }

        return found;
    }

    /**
     * Method to insert insertItem in the binary search tree.
     * If no node in the binary tree has the same info as insertItem, a node with
     * info insertItem is created and inserted in the binary tree.
     *
     * @param insertItem
     */
    @Override
    public void insert(T insertItem) {
        BinaryTreeNode<T> current;  //reference variable to traverse the tree
        BinaryTreeNode<T> trailCurrent; //reference variable behind current
        BinaryTreeNode<T> newNode;  //reference variable to create the node

        newNode = new BinaryTreeNode<T>(insertItem, null, null);

        if (root == null){
            root = newNode;
        }else{
            current = root;

            while (current != null){
                trailCurrent = current;
                Comparable<T> temp1 = (Comparable<T>)current.info;

                if (temp1.compareTo(insertItem) == 0){
                    System.err.println("The insert item is already in the tree -- duplicates are not allowed.");
                    return;
                }else if (temp1.compareTo(insertItem) > 0){
                    //insertItem is less than current; follow lLink of current
                    current = current.lLink;

                }else{
                    //insertItem is greater than current; follow rLink of current
                    current = current.rLink;
                }

                //insert the new node in the correct place
                Comparable<T> temp2 = (Comparable<T>)trailCurrent.info;
                if (temp2.compareTo(insertItem) > 0){
                    //make the new node the left child of trailCurrent
                    trailCurrent.lLink = newNode;

                }else{
                    //make the new node the right child of trailCurrent
                    trailCurrent.rLink = newNode;
                }
            }
        }
    }

    /**
     * Method to delete deleteItem from the binary search tree.
     * If a node with the same info as deleteItem is found, it is deleted from the
     * binary tree.
     *
     * @param deleteItem
     */
    @Override
    public void deleteNode(T deleteItem) {
        //TODO
    }

    /**
     * Method to delete the node to which p points from the binary search tree
     * @param p
     * @return The reference of the root node of the binary search tree after
     * deletion is returned.
     */
    private BinaryTreeNode<T> deleteFromTree(BinaryTreeNode<T> p){
        //TODO
        return null;
    }
}
