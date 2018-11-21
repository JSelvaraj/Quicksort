package impl;

import java.io.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NearlySorted {

    /**
     *
     * This method selects a number (unsortedness/size, for simiplicity we will assume this is always a whole number of
     * random elements from a linked list) take them and randomly insert them in a new list, then take the remaining
     * members of the first list (which is still sorted) and append them to the new list.
     *
     * @param linkedList the sorted input list to be turned into a nearly sorted state.
     * @param numberOfRemovals the number of random elements put to the front of the list.
     */


    public static ArrayList<Integer> removal(ArrayList<Integer> linkedList, int numberOfRemovals) {
        Random random = new Random();
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < numberOfRemovals; i++) {
            newList.add(linkedList.remove(random.nextInt(linkedList.size())));
        }
        newList.addAll(linkedList);
        return newList;
    }

    public static ArrayList<Integer> removalFront(ArrayList<Integer> linkedList, int numberOfRemovals) {
        Random random = new Random();
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < numberOfRemovals; i++) {
            newList.add(linkedList.remove(random.nextInt(linkedList.size())));
        }
        newList.addAll(0, linkedList);
        return newList;
    }


    public static ArrayList<Integer> exchange(ArrayList<Integer> linkedList, int numberOfSwaps) {
        Random random = new Random();
        int index1;
        int index2;
        for (int i = 0; i < numberOfSwaps; i++) {
            do {
                index1 = random.nextInt(linkedList.size() - 1);
                index2 = random.nextInt(linkedList.size() - 1);
            } while (index1 == index2);
            Integer temp = linkedList.get(index1);
            linkedList.remove(index1);
            linkedList.add(index1, linkedList.get(index2));
            linkedList.remove(index2);
            linkedList.add(index2, temp);
        }
        return linkedList;
    }




}
