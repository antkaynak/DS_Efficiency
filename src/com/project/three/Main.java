package com.project.three;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 * */
public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            getUserInput();
        } catch (InputMismatchException ime) {
            System.err.println("Please enter an Integer!");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred. Please try again.");
        }

    }

    public static void getUserInput() throws Exception {
        MyArrayList L1 = new MyArrayList();
        MyArrayList L2 = new MyArrayList();
        Operation operation = new Operation();
        System.out.println("Do you want auto generated lists? [ Y / N ]");
        String userChoice = new Scanner(System.in).nextLine();
        //If the user wants auto generated lists.
        if (userChoice.toUpperCase().startsWith("Y")) {
            Random r = new Random();
            for (int i = 0; i < r.nextInt(20)+1; i++) {
                L1.add(r.nextInt(20));
            }
            for (int i = 0; i < r.nextInt(20)+1; i++) {
                L2.add(r.nextInt(20));
            }

        } else {
            //If the user wants to enter his/her own values.
            System.out.println("Please enter Integers for the first list... ( -1 to finish )");
            while (true) {
                int inputL1 = scanner.nextInt();
                if (inputL1 == -1) break;
                L1.add(inputL1);
            }
            System.out.println("Please enter Integers for the second list... ( -1 to finish )");
            while (true) {
                int inputL2 = scanner.nextInt();
                if (inputL2 == -1) break;
                L2.add(inputL2);
            }

        }

        operation.quickSort(L1);
        operation.quickSort(L2);
        System.out.println(L1);
        System.out.println(L2);
        System.out.println("Lists are merging...");
        MyArrayList L3 = operation.mergeListSortedInt(L1, L2);
        if (L3 == null || L3.size() == 0) {
            System.out.println("These lists are empty.");
            return;
        }
        System.out.println("****************************************");
        System.out.println("New list");
        System.out.println(L3);
        System.out.println("****************************************");

    }

}
