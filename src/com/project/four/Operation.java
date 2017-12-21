package com.project.four;

public class Operation {

    /**
     * Method overloading.
     * Traverses both Circular lists in linear.
     * Checks node's data from the lists if
     * they are the same or not.
     * If even one of the index nodes are not
     * the same returns false.
     * @param L1,L2 are the lists to traverse.
     * @return true if they are the same, otherwise false.
     * */
    private boolean testEquality(CircularLinkedList L1, CircularLinkedList L2, CircularLinkedList.Node tempStartL2){
        CircularLinkedList.Node startL1 = L1.getStart();
        while(startL1.link != L1.getStart()){
            if(startL1.data != tempStartL2.data){
                return false;
            }
            startL1 = startL1.link;
            tempStartL2 = tempStartL2.link;
        }

        return true;
    }

    /**
     * Checks if the lists are the same list
     * with different start (head) nodes.
     * Searches L1's start in the other list.
     * When it finds one, it does not wait until
     * it finds all the available start nodes,
     * calls the method testEquality and sends
     * it to the node.
     * @param L1,L2 are the lists to traverse.
     * @return true if testEquality w/ node method
     * returns true, otherwise false.
     */
    public boolean testEquality(CircularLinkedList L1, CircularLinkedList L2){

        //If these list's sizes are not the same, they are not the same.
        //This if check increases efficiency significantly.
        if(L1.getSize() != L2.getSize()){
            return false;
        }

        //We did not have to assign L1 to a variable
        //but we did it anyways to clarify the code.
        //But we must assign L2 start so we would not
        //lose start point for the L2 after we traverse
        //the list.
        CircularLinkedList.Node startL1 = L1.getStart();
        CircularLinkedList.Node startL2 = L2.getStart();

        while(true){
            //If the data's are equal we have found a start node.
            //We add those start nodes to list because lists may contain
            //same numbers.
            if(startL2.data == startL1.data){
                if(testEquality(L1,L2,startL2)) return true;
            }

            //break from loop when we have traversed all the list.
            if(startL2.link == L2.getStart()){
                break;
            }
            startL2 = startL2.link;
        }

        return false;

    }
}
