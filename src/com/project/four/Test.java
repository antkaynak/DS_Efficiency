package com.project.four;

import java.util.Random;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class Test {

    private static final Integer randomLimit = 4;
    private static final Integer insertLimit = 4;
    private static final Integer[] testL1 = {1,2,3,2,1};
    private static final Integer[] testL2 = {3,2,1,1,2};

    /**
     * Test Class for Project 4
     *
     * Suppose you are given two circular singly linked lists, L and M, that is, two lists of
     * nodes such that each node has a non-null next node. Write a Java program with a fast
     * algorithm for telling if L and M are really the same list of nodes, but with different
     * (cursor) starting points. (You can assume that the lists contains only integer values)
     *
     *
     * */
    public static void main(String[] args) {
        try {
            CircularLinkedList L1 = new CircularLinkedList();
            CircularLinkedList L2 = new CircularLinkedList();
            Operation operation = new Operation();
            Random r = new Random();
            System.out.println("-------------------------");
            System.out.println("Filling the first list with random numbers.");
            for (int i = 0; i < r.nextInt(insertLimit)+1; i++) {
                L1.append(r.nextInt(randomLimit));
            }
            System.out.println("Done.");
            System.out.println(L1);
            System.out.println("-------------------------");
            System.out.println("Filling the second list with random numbers.");
            for (int i = 0; i < r.nextInt(insertLimit)+1; i++) {
                L2.append(r.nextInt(randomLimit));
            }
            System.out.println("Done.");
            System.out.println(L2);
            System.out.println("-------------------------");
            System.out.println("Checking if these lists are the same \nlists with different start(head) points.");

            if(operation.testEquality(L1,L2)){
                System.out.println("\nThese lists are the same.");
            }else{
                System.out.println("\nThese lists are different.");
            }

            System.out.println("-------------------------");
            System.out.println("Creating two same lists with different starting points.");
            L1 = new CircularLinkedList();
            L2 = new CircularLinkedList();
            for(Integer i : testL1){
                L1.append(i);
            }
            for(Integer i : testL2){
                L2.append(i);
            }
            System.out.println(L1);
            System.out.println(L2);
            System.out.println("-------------------------");
            System.out.println("Checking if these lists are the same \nlists with different start(head) points.");
            System.out.println("The return value must be true.");
            if(operation.testEquality(L1,L2)){
                System.out.println(true);
                System.out.println("\nThese lists are the same.");
                System.out.println("Test passed.");
            }else{
                System.out.println("\nThese lists are different.");
                System.out.println("Test failed.");
            }


            System.out.println("\n\n-------------------------");
            System.out.println("Test end");
            System.out.println("-------------------------");

        }

        catch (Exception ex){
            ex.printStackTrace();
            System.err.println("An error occurred.");
        }

    }


}

