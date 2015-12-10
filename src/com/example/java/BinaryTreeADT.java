package com.example.java;

/**
 * Interface to implement a binary tree as an abstract data type
 * Created by vagrant on 12/9/15.
 */
public interface BinaryTreeADT <T>{

    /**
     * Method to clone the references stored in the nodes of the binary tree.
     * The objects that the binary tree nodes point to are not cloned.
     * @return A clone of the binary tree
     */
    public Object clone();

    /**
     * Method to determine whether the binary tree is empty
     * @return True if binary tree is empty, otherwise returns false
     */
    public boolean isEmpty();

    /**
     * Recursive method for performing inorder traversal of binary tree.
     * Inorder traversal:
     * 1. Traverse left subtree
     * 2. Visit node
     * 3. Traverse right subtree
     * Great for printing the values of a binary search tree (BST)
     */
    public void inorderTraversal();

    /**
     * Recursive method for performing preorder traversal of binary tree.
     * Preorder traversal:
     * 1. Visit node
     * 2. Traverse left subtree
     * 3. Traverse right subtree
     * Great for making a copy of a tree whilst keeping the same structure
     */
    public void preorderTraversal();

    /**
     * Recursive method for performing postorder traversal of binary tree.
     * Postorder traversal:
     * 1. Traverse left subtree
     * 2. Traverse right subtree
     * 3. Visit node
     * Great for deleting all of the nodes in the tree
     */
    public void postorderTraversal();

    /**
    * Method to find the height of the binary tree.
    * The height of a binary tree is the number of nodes on the longest path
    * from the root to a leaf.
    * @return The height of the binary tree
            */
    public int treeHeight();

    /**
     * Method to determine the number of nodes in the binary tree
     * @return The number of nodes in the binary tree
     */
    public int treeNodeCount();

    /**
     * Method to detemine the number of leaves in the binary tree.
     * A leaf is a node that does not have any children.
     * @return The number of leaves in the binary tree.
     */
    public int treeLeavesCount();

    /**
     * Method to destroy the binary tree
     */
    public void destroyTree();

    /**
     * Method to determine whether searchItem is in the binary tree.
     * @param searchItem
     * @return Returns true if searchItem is found in the binary tree; otherwise false.
     */
    public boolean search (T searchItem);

    /**
     * Method to insert insertItem in the binary tree.
     * If no node in the binary tree has the same info as insertItem, a node with
     * info insertItem is created and inserted in the binary tree.
     * @param insertItem
     */
    public void insert(T insertItem);

    /**
     * Method to delete deleteItem from the binary tree.
     * If a node with the same info as deleteItem is found, it is deleted from the
     * binary tree.
     * @param deleteItem
     */
    public void deleteNode(T deleteItem);
}

