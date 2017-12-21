package com.project.one;


import java.util.Random;

/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class Test {

    private static final Integer testNumber = 999;
    private static final Integer randomLimit = 100;
    private static final Integer insertLimit = 20;

    /**
     * Test Class for Project 1
     *
     * Write a Java program that takes a sequence of integer values and when the user enters
     a number that already given before, the program stops, otherwise it continues to get
     numbers. (i.e, the program runs endlessly if all the numbers are distinct from each
     other).
     *
     * In this case simply testing inserting values and
     * testing contains method will be enough to prove
     * that this program is running perfectly.
     *
     *
     * */
    public static void main(String[] args) {
        try {
        BinarySearchTree list = new BinarySearchTree();
        Random random = new Random();

        System.out.println("-------------------------");
        System.out.println("Testing Insertion method");
        System.out.println("-------------------------");
        insertRandomNumbers(list,random);
        System.out.println("-------------------------");
        //The list does not have this number because
        //the random limit is capped at 100.
        //If you increase the cap, the also should increase
        //testNumber
        System.out.println("Inserting a number that list does not have ( "+testNumber+" ) ");
        list.insertIteratively(testNumber);
        System.out.println("Inserted "+testNumber);
        System.out.println("-------------------------");
        System.out.println("Inserting some random numbers again");
        insertRandomNumbers(list,random);
        System.out.println("-------------------------");
        list.printInorder();
        System.out.println("\n-------------------------");
        System.out.println("Trying to insert "+testNumber+" again.");
        if(list.insertIteratively(testNumber)){
            System.out.println("The list already has "+ testNumber);
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

    private static void insertRandomNumbers(BinarySearchTree list, Random random) throws Exception{
        for(int i=0; i< insertLimit; i++){
            Integer temp = random.nextInt(randomLimit);
            list.insertIteratively(temp);
        }
        System.out.println("Inserted "+insertLimit+" random numbers");
    }
}
