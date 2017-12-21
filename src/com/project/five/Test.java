package com.project.five;

/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class Test {

    /**
     * Test Class for Project 5
     *
     * Suppose you are given a list of String values. Write a Java program with an efficient
     * method for removing all duplicates from this collection.
     *
     *
     * */
    public static void main(String[] args) {
        try {
            Operation operation = new Operation();
            System.out.println("-------------------------");
            System.out.println(operation.getWords());
            System.out.println("-------------------------");
            System.out.println("Picking random number of Strings from the list above.");
            MyArrayList<String> randomWordList = operation.getRandomWords();
            System.out.println(randomWordList);
            System.out.println("-------------------------");
            System.out.println("Removing duplicates");
            operation.removeDuplicates(randomWordList);
            System.out.println("-------------------------");
            System.out.println("Final list is " +randomWordList);
            System.out.println("-------------------------");
            System.out.println("Creating a list which contains same strings more than once.");
            MyArrayList<String> testWordList = new MyArrayList<>();
            testWordList.add("a");
            testWordList.add("b");
            testWordList.add("a");
            testWordList.add("b");
            testWordList.add("b");
            testWordList.add("c");
            testWordList.add("d");
            testWordList.add("c");
            testWordList.add("a");
            System.out.println(testWordList);
            System.out.println("-------------------------");
            System.out.println("Removing duplicates");
            operation.removeDuplicates(testWordList);
            System.out.println("-------------------------");
            System.out.println("Final list is " +testWordList);
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
