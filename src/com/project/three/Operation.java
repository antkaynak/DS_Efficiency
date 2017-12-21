package com.project.three;

public class Operation {

    /**
     * Merges two sorted lists and creates a new list which Its elements
     * are also sorted.
     * Checks if the lists are empty to increase efficiency.
     * @param L1 and L2 are the lists to merge.
     * @return the new merged list.
     */
    public MyArrayList mergeListSortedInt(MyArrayList L1, MyArrayList L2){

        //**************NOTE********************
        //We did not use quick sort method here
        //Quick Sort method is meant to be only used
        //for the user input.
        //Actual sorting is in here.
        //If you want to use quick sort method,
        //merge two lists and then use quick sort function
        //to sort the third list.
        //But this method's approach is fast and efficient
        //enough without qs algorithm.


        System.out.println("L1 Size: "+ L1.size());
        System.out.println("L2 Size: "+ L2.size());

        /* If one of the list is empty then merge result would be equal to the other list */
        if(L1.size() == 0 && L2.size() > 0){
            return L2;
        }else if(L2.size() == 0 && L1.size() > 0){
            return L1;
        }else if(L1.size() == 0 && L2.size() == 0){
            return null;
        }

        MyArrayList mergedList = new MyArrayList();

        int i =0, j= 0;
        //Loop till one of the indexes are equal to list's size.
        while(i != L1.size() && j != L2.size()){
            if(L1.get(i) < L2.get(j)){
                mergedList.add(L1.get(i));
                i++;
            }
            else if(L1.get(i) > L2.get(j)){
                mergedList.add(L2.get(j));
                j++;
            }
            else{
                //Does not matter which one gets added
                //because both are the same.
                mergedList.add(L1.get(i));
                //We can delete one of these if we only
                //want the same integers once in the list.
                mergedList.add(L2.get(j));
                i++;
                j++;
            }
        }
        //After the process determine if any data item left and
        //which list has them. If i is equal to the L1's size
        //that would mean all the items in L1 have been added
        //to the mergesList. So add L2's left items.
        //start from the i or j value where it is left off,
        //not from 0. that would add the entire list.
        if(i == L1.size() && j != L2.size()){
            while (j < L2.size()){
                mergedList.add(L2.get(j));
                j++;
            }
        }else if ( j == L2.size() && i != L1.size()){
            while (i < L1.size()){
                mergedList.add(L1.get(i));
                i++;
            }
        }

        return mergedList;

    }

    /**
     * Method overloading
     * Uses other quickSort method
     * left is 0 because list starts from zero
     * right is size minus 1 because of the
     * index value is 1 smaller than actual
     * list size.
     * @param  list is the list to be sorted.
     * */
    public void quickSort(MyArrayList list){
        if(list.isEmpty()) return;
        quickSort(list, 0, list.size()-1);
    }

    /**
     * Quick Sort Algorithm
     *
     * @param list is the list to be sorted.
     * @param left recursive start index.
     * @param right recursive end index.
     * */
    private void quickSort(MyArrayList list, int left, int right) {
        //get the partition and assign it to index
        //so we can divide the list and continue on
        //with recursive approach.
        int index = partition(list, left, right);

        //if the list is the left side from
        //the pivot point.
        if (left < index - 1){
            quickSort(list, left, index - 1);
        }

        //if the list is the right side from
        //the pivot point.
        if (index < right){
            quickSort(list, index, right);
        }

    }

    /**
     * Quick sort's partition part.
     * Parameters must match with the
     * quickSort method.
     * @param list is the list to be sorted.
     * @param left recursive start index.
     * @param right recursive end index.
     * */
    private int partition(MyArrayList list, int left, int right)
    {
        int i = left, j = right;
        int pivot = list.get((left + right) / 2);

        //while the left part is lesser
        // or equal to the right part
        while (i <= j) {
            //if the index i element is lesser than pivot element
            //increase i, otherwise decrease j. We are decreasing
            //j instead of increasing because the j
            //index is not at the start of the list but
            //at the end of it.
            while (list.get(i) < pivot){
                i++;
            }
            while (list.get(j) > pivot){
                j--;
            }
            //after the loops swap the element
            //from the first and last indexes
            //towards the pivot element
            if (i <= j) {
                swapItem(list, i,j);
                i++;
                j--;
            }
        }

        return i;
    }

    /**
     * Swaps the items at position idx1 and idx2.
     * @param idx1 and idx2 the index to change.
     * @throws ArrayIndexOutOfBoundsException if indexes are out of range.
     */
    private void swapItem(MyArrayList list, int idx1, int idx2){
        if( idx1 < 0 || idx1 >= list.size( ) || idx2 < 0 || idx2 >= list.size( ))
            throw new ArrayIndexOutOfBoundsException( "Index " + idx1 + " " + idx2 + "; size " + list.size( ) );
        Integer temp = list.get(idx2);
        list.set(idx2, list.get(idx1));
        list.set(idx1, temp);
    }


}
