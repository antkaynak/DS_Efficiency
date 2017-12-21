package com.project.five;

import java.util.Random;

public class Operation {

    private static final Integer randomStringLimit = 10;

    private String[] words = {"consider", "minute", "accord", "evident",
            "practice","intend","commit","issue","handle","gamble","destiny",
            "this","program","is","really","cool","he","she", "it"};

    /**
     * @param r is the random object.
     * @return a random string from the words array.
     * */
    private String randomString(Random r) {
        return words[r.nextInt(words.length - 1)];
    }

    /**
     * @return a MyArrayList which contains
     * random words from the words array.
     * The random word count is capped with
     * the randomStringLimit variable.
     * */
    public MyArrayList<String> getRandomWords(){
        Random r = new Random();
        MyArrayList<String> list = new MyArrayList<String>();
        for(int i = 0; i < r.nextInt(randomStringLimit)+5; i++) {
            list.add(randomString(r));
        }
        return list;
    }

    /**
     * @return a string which contains strings
     * in the words array.
     * */
    public String getWords(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for(String i : words){
            stringBuilder.append(" ").append(i);
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }


    /**
     * Removes the duplicate strings from this collection.
     * Uses 2 for loop to check every individual String.
     * No need to check the first index in the second loop
     * Otherwise we would check the String with Itself.
     * Every time a duplicate has been found remove it
     * from the list and subtract j because the array
     * has been re-indexed. This increases efficiency.
     * @param list is the list to process.
     * @return the list that has been processed.
     */
    public MyArrayList<String> removeDuplicates(MyArrayList<String> list) {

        //We subtract 1 from the list's size for the first loop
        //because we do not need the last index.
        for (int i = 0; i < list.getTheSize() - 1; i++) {
            //Don't have to check the first index.
            for (int j = i + 1; j < list.getTheSize(); j++) {
                //If We would want to make this case sensitive we would not
                // use equalsIgnoreCase, would have just used equals.
                if (list.get(j).trim().equalsIgnoreCase(list.get(i))){
                    list.remove(j);
                    //Decrease j because we deleted an element from array.
                    //the list.getTheSize will decrease because of the
                    //built in remove method decreases it automatically.
                    j--;
                }
            }
        }

        return list;

    }
}
