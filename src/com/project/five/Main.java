package com.project.five;


import java.util.InputMismatchException;
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
        }catch (InputMismatchException ime){
            System.err.println("Please enter a String!");
        }
        catch (Exception e) {
            System.err.println("An error occurred. Please try again.");
        }


    }

    public static void getUserInput() throws Exception{
        MyArrayList<String> L1;
        Operation operation = new Operation();
        System.out.println("Do you want auto generated list? [ Y / N ]");
        String userChoice = new Scanner(System.in).nextLine();
        if(userChoice.toUpperCase().startsWith("Y")){
            L1 = operation.getRandomWords();
        }else{
            L1 = new MyArrayList<>();
            System.out.println("Please enter Strings for the list... ( -1 to finish )");
            while(true){
                String inputL1 = scanner.nextLine();
                if(inputL1.toUpperCase().equals("-1")) break;
                L1.add(inputL1);
            }

        }

        System.out.println(L1);
        System.out.println("Removing duplicates...");
        System.out.println("New list : "+ operation.removeDuplicates(L1));

    }

}
