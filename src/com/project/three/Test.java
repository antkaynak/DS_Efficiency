package com.project.three;

import java.util.Random;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class Test {

    private static final Integer randomLimit = 20;
    private static final Integer insertLimit = 20;

    /**
     * Test Class for Project 3
     *
     * Given two sorted lists L1 and L2, write a Java program to generate a third list which
     * contains the same nodes of L1 and L2. (You can assume that the lists contains only
     * integer values)
     *
     *
     * */
    public static void main(String[] args) {
        try {
            MyArrayList L1 = new MyArrayList();
            MyArrayList L2 = new MyArrayList();
            Operation operation = new Operation();
            Random r = new Random();
            System.out.println("-------------------------");
            System.out.println("Filling the first list with random numbers.");
            for (int i = 0; i < r.nextInt(insertLimit)+1; i++) {
                L1.add(r.nextInt(randomLimit));
            }
            System.out.println("Done.");
            System.out.println(L1);
            System.out.println("-------------------------");
            System.out.println("Filling the second list with random numbers.");
            for (int i = 0; i < r.nextInt(insertLimit)+1; i++) {
                L2.add(r.nextInt(randomLimit));
            }
            System.out.println("Done.");
            System.out.println(L2);
            System.out.println("-------------------------");
            System.out.println("Sorting both lists.");
            operation.quickSort(L1);
            operation.quickSort(L2);
            System.out.println("Done.");
            System.out.println(L1);
            System.out.println(L2);
            System.out.println("-------------------------");
            System.out.println("Creating a third list which contains \nnodes in L1 and L2 and is sorted.");
            MyArrayList L3 = operation.mergeListSortedInt(L1,L2);
            //Worth noting that we did not use quick sort method. The operation mergeListSorted method is
            //creating the third list sorted right away.
            System.out.println("Done.");
            System.out.println(L3);
            System.out.println("-------------------------");


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

