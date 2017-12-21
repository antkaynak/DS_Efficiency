package com.project.four;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class CircularLinkedList {
    private Node start;
    private int size;

    /**
     * Adds an item to this collection, at the end.
     * @param x integer data.
     */
    public void append(int x){
        size++;
        Node temp=new Node(x);
        if(start==null){
            start=temp;
        }else{
            Node tp=start;
            while(tp.link!=start){
                tp=tp.link;
            }
            tp.link=temp;
        }
        temp.link=start;
    }

    /**
     * Removes the first item from this collection.
     */
    public void deleteFirst() {
        Node temp=start;
        while(temp.link!=start){
            temp=temp.link;
        }
        temp.link=start.link;
        start=start.link;
        size--;
    }

    @Override
    public String toString() {
        if(start==null)
            return "The list is empty!";
        else{
            String rStr = "[ ";
            Node temp=start;
            while(temp.link!=start){
                rStr = rStr+temp.data+" ";
                temp=temp.link;
            }
            rStr = rStr + temp.data+ " ]";
            return rStr;
        }
    }

    /**
     * @return the size.
     */
    public int getSize(){
        return size;
    }

    /**
     * @return the start node.
     */
    public Node getStart() {
        return start;
    }

    class Node{
    int data;
    Node link;
    public Node(int data){
        this.data=data;
    }
    public Node(int data,Node link){
        this.data=data;
        this.link=link;
        }
    }


}