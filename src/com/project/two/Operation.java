package com.project.two;


/**
 * @author Pellumb Baboci - 160315049
 * @author Ant Kaynak - 150315004
 **/
public class Operation {


    /**
     * Creates a new Sorted Array List with the same values of L1 and L2.
     * @param L1 and L2 are the lists to merge.
     * @throws ArrayIndexOutOfBoundsException if indexes is out of range.
     */
    public MyArrayList mergeListSameValuesSortedInt(MyArrayList L1, MyArrayList L2){

        System.out.println("L1 Size: "+ L1.size());
        System.out.println("L2 Size: "+ L2.size());

        // Even If one of the list is empty that would mean the generated list would be empty
        if(L1.size() == 0 || L2.size() == 0){
            return null;
        }

        MyArrayList mergedList = new MyArrayList();

        // The one with the smaller size is the one we want to search in the other list
        //because that would mean lesser contains check for elements.
        if(L1.size() <= L2.size()){
            for(int i = 0; i < L1.size(); i++){
                //If you want to enable adding same data elements
                //more than once just remove contain check on
                //mergedList.
                if(containsBinary(L2,L1.get(i)) && !containsBinary(mergedList,L1.get(i))){
                    mergedList.add(L1.get(i));
                }
            }
        }else if(L2.size() < L1.size()){
            for(int i = 0; i < L2.size(); i++){
                //If you want to enable adding same data elements
                //more than once just remove contain check on
                //mergedList.
                if(containsBinary(L1,L2.get(i)) && !containsBinary(mergedList,L2.get(i))){
                    mergedList.add(L2.get(i));
                }
            }
        }
        return mergedList;

    }

    /**
     * Checks list to find a data.
     * Only works with sorted lists.
     * Divides list to 2 and checks the value, if it is;
     * the middle element It has found the data,
     * lesser than middle element It assigns end to middle,
     * greater than middle element It assigns start to middle.
     * @param value is the data It checks if the list contains.
     * @return If data exists return true, otherwise return false.
     */
    private boolean containsBinary(MyArrayList list, Integer value){
        if(list.isEmpty()){
            return false;
        }
        int start = 0;
        int end = list.size() - 1 ;
        while (start <= end) {
            int mid = (start + end) / 2;
            // If it is the middle element We have found the data
            //equals is a native java Integer class method
            //and helps us to compare two auto-boxed Integer values.
            if(value.equals(list.get(mid))){
                return true;
            }
            if (value < list.get(mid)) {
                // subtract 1 from mid because It will end on that number and We don't want to check mid again.
                end = mid - 1;
            } else {
                // add 1 to mid because It will start from that number and We don't want to check mid again.
                start = mid + 1;
            }
        }
        return false;

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
