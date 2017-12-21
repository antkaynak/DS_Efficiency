package com.project.one;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BinarySearchTree list = new BinarySearchTree();

    public static void main(String[] args) {
        System.out.println("Please enter an Integer...");
        System.out.println("If you enter the same Integer twice, program will shutdown!");
        try {
            while(getUserInput()){}
        }catch (InputMismatchException ime){
            System.err.println("Please enter an Integer!");
        }
        catch (Exception e) {
            System.err.println("An error occurred. Please try again.");
        }

    }

    public static boolean getUserInput() throws Exception {
        Integer input = scanner.nextInt();
        if(list.insertIteratively(input)){
            System.out.printf("You have already entered %d.\nThe program will shutdown. ", input);
            return false;
        }
        return true;
    }
}