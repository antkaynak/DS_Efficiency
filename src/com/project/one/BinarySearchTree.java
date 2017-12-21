package com.project.one;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Method overloading.
     * Sends root node to other printInorder method.
     * */
    public void printInorder() {
        printInorder(root);
    }

    /**
     * Prints the tree in
     * Left - Node(Root) - Right order.
     * This method is recursive and only
     * used in testing class.
     * So the performance is not a concern.
     * */
    private void printInorder(Node tempNode) {
        if (tempNode != null) {
            if (tempNode.hasLeft()){
                printInorder(tempNode.getLeft());
            }
            System.out.print(tempNode.getElement() + " ");
            if (tempNode.hasRight()){
                printInorder(tempNode.getRight());
            }
        }
    }


    /**
     * Traverses the tree and checks Node's data.
     * If the Integer value is smaller checks the left node
     * If the Integer value is bigger checks the right node
     * Breaks from the loop until either It finds the data
     * or temporary traversing pointer equals to null which
     * can happen if the list does not contain the data.
     * Adds Integer data to Binary Search Tree if the list
     * does not have the same Integer data.
     * @param newValue the Integer data to be added
     * */
    public boolean insertIteratively(int newValue) {
        Node newNode = new Node(newValue, null, null);

        //While adding the first Node.
        if (isEmpty()) {
            root = newNode;
            return false;
        }
        else {
            Node tempNode = root;

            while (true) {
                //If the new value is smaller, check the left pointer
                //If It is empty add to the left pointer.
                //If not continue from the left node.
                if (newValue < tempNode.getElement()) {
                    if (tempNode.getLeft() == null) {
                        tempNode.setLeft(newNode);
                        return false;
                    } else {
                        tempNode = tempNode.getLeft();
                    }
                }
                //If the new value is smaller, check the right pointer
                //If It is empty add to the right pointer.
                //If not continue from the right node.
                else if(newValue > tempNode.getElement()){
                    if (tempNode.getRight() == null) {
                        tempNode.setRight(newNode);
                        return false;
                    } else {
                        tempNode = tempNode.getRight();
                    }
                }else{
                    return true;
                }
            }
        }
    }

    private class Node
    {
        private int element;
        private Node left;
        private Node right;

        public Node(int i, Node l, Node r)
        {
            element = i;
            left = l;
            right = r;
        }

        public int getElement()
        {
            return element;
        }

        public Node getLeft()
        {
            return left;
        }

        public Node getRight()
        {
            return right;
        }

        public void setElement(int newElem)
        {
            element = newElem;
        }

        public void setLeft(Node newLeft)
        {
            left = newLeft;
        }

        public void setRight(Node newRight)
        {
            right = newRight;
        }

        public boolean hasLeft()
        {
            return (left != null);
        }

        public boolean hasRight()
        {
            return (right != null);
        }
    }

}
