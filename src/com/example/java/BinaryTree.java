package com.example.java;

public abstract class BinaryTree<T> implements BinaryTreeADT<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    /**
     * Method to determine whether the binary tree is empty
     *
     * @return True if binary tree is empty, otherwise returns false
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Recursive method for performing inorder traversal of binary tree.
     * Inorder traversal:
     * 1. Traverse left subtree
     * 2. Visit node
     * 3. Traverse right subtree
     * Great for printing the values of a binary search tree (BST)
     */
    @Override
    public void inorderTraversal() {
        inorder(root);
    }

    /**
     * Recursive method for performing preorder traversal of binary tree.
     * Preorder traversal:
     * 1. Visit node
     * 2. Traverse left subtree
     * 3. Traverse right subtree
     * Great for making a copy of a tree whilst keeping the same structure
     */
    @Override
    public void preorderTraversal() {
        preorder(root);
    }

    /**
     * Recursive method for performing postorder traversal of binary tree.
     * Postorder traversal:
     * 1. Traverse left subtree
     * 2. Traverse right subtree
     * 3. Visit node
     * Great for deleting all of the nodes in the tree
     */
    @Override
    public void postorderTraversal() {
        postorder(root);
    }

    /**
     * Method to find the height of the binary tree.
     * The height of a binary tree is the number of nodes on the longest path
     * from the root to a leaf.
     *
     * @return The height of the binary tree
     */
    @Override
    public int treeHeight() {
        return height(root);
    }

    /**
     * Method to determine the number of nodes in the binary tree
     *
     * @return The number of nodes in the binary tree
     */
    @Override
    public int treeNodeCount() {
        return nodeCount(root);
    }

    /**
     * Method to detemine the number of leaves in the binary tree.
     * A leaf is a node that does not have any children.
     *
     * @return The number of leaves in the binary tree.
     */
    @Override
    public int treeLeavesCount() {
        return leavesCount(root);
    }

    /**
     * Method to destroy the binary tree
     */
    @Override
    public void destroyTree() {
        root =  null;
    }


    /**
     * Method to find the height of the binary tree.
     * The height of a binary tree is the number of nodes on the longest path
     * from the root to a leaf.
     *
     * @param p
     * @return
     */
    private int height(BinaryTreeNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + Math.max(height(p.lLink), height(p.rLink));
        }
    }

    /**
     * Recursive method for performing inorder traversal of binary tree.
     * Inorder traversal:
     * 1. Traverse left subtree
     * 2. Visit node
     * 3. Traverse right subtree
     * Great for printing the values of a binary search tree (BST)
     *
     * @param p
     */
    private void inorder(BinaryTreeNode<T> p) {
        if (p != null) {
            inorder(p.lLink);
            System.out.println(p + " ");
            inorder(p.rLink);
        }
    }

    /**
     * Recursive method for performing preorder traversal of binary tree.
     * Preorder traversal:
     * 1. Visit node
     * 2. Traverse left subtree
     * 3. Traverse right subtree
     * Great for making a copy of a tree whilst keeping the same structure
     *
     * @param p
     */
    private void preorder(BinaryTreeNode<T> p) {
        if (p != null) {
            System.out.println(p + " ");
            preorder(p.lLink);
            preorder(p.rLink);
        }
    }

    /**
     * Recursive method for performing postorder traversal of binary tree.
     * Postorder traversal:
     * 1. Traverse left subtree
     * 2. Traverse right subtree
     * 3. Visit node
     * Great for deleting all of the nodes in the tree.
     *
     * @param p
     */
    private void postorder(BinaryTreeNode<T> p) {
        if (p != null) {
            postorder(p.lLink);
            postorder(p.rLink);
            System.out.println(p + " ");
        }
    }

    /**
     * Method to find the number of nodes in the binary tree.
     *
     * @param p
     * @return The number of nodes
     */
    private int nodeCount(BinaryTreeNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + Math.max(height(p.lLink), height(p.rLink));
        }
    }

    /**
     * Method to find the number of leaves in the binary tree.
     * @param p
     * @return The number of leaves
     */
    private int leavesCount(BinaryTreeNode<T> p) {
        if (p == null) {
            return 0;
        } else {
            return 1 + Math.max(height(p.lLink), height(p.rLink));
        }
    }

    /**
     * Method to copy a given binary tree.
     *
     * @param otherTreeRoot
     * @return A reference to the root node of the copied tree
     */
    private BinaryTreeNode<T> copyTree(BinaryTreeNode<T> otherTreeRoot) {
        BinaryTreeNode<T> temp;

        if (otherTreeRoot == null) {
            temp = null;
        } else {
            temp = (BinaryTreeNode<T>) otherTreeRoot.clone();
            temp.lLink = copyTree(otherTreeRoot.lLink);
            temp.rLink = copyTree(otherTreeRoot.rLink);
        }

        return temp;
    }

    /**
     * This method clones the references stored in the nodes of the binary tree.
     * The objects that the binary tree nodes point to are not cloned.
     *
     * @return A clone of the binary tree
     */
    public Object clone() {
        BinaryTree<T> copy = null;

        try {
            copy = (BinaryTree<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }

        if (root != null){
            copy.root = copyTree(root);
        }

        return copy;
    }



    /**
     * Definition of a class implementing binary nodes
     * Created by vagrant on 12/9/15.
     */
    protected class BinaryTreeNode<T> {
        public T info;
        public BinaryTreeNode<T> lLink;
        public BinaryTreeNode<T> rLink;

        /**
         * @param info
         * @param lLink
         * @param rLink
         */
        public BinaryTreeNode(T info, BinaryTreeNode<T> lLink, BinaryTreeNode<T> rLink) {
            this.info = info;
            this.lLink = lLink;
            this.rLink = rLink;
        }

        /**
         * Default constructor
         */
        public BinaryTreeNode() {
            info = null;
            lLink = null;
            rLink = null;
        }

        /**
         * This method clones the references stored in the nodes of the binary tree.
         * The objects that the binary tree nodes point to are not cloned.
         *
         * @return A clone of the binary tree
         */
        public Object clone() {
            BinaryTreeNode<T> copy = null;

            try {
                copy = (BinaryTreeNode<T>) super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }

            return copy;
        }

        public String toString() {
            return info.toString();
        }
    }
}




