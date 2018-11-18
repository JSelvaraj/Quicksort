package impl;

import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class NearlySorted {

    private static LinkedList<Integer> readList () {
        try {
            File input = new File("TestLists/sorted.txt");
            Scanner scanner = new Scanner(input);

            LinkedList<Integer> linkedList = new LinkedList<>();
            while (scanner.hasNext()) {
                linkedList.add(scanner.nextInt());
            }
            scanner.close();
            return linkedList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * This method selects a number (unsortedness/size, for simiplicity we will assume this is always a whole number of
     * random elements from a linked list) take them and randomly insert them in a new list, then take the remaining
     * members of the first list (which is still sorted) and append them to the new list.
     *
     * @param linkedList the sorted input list to be turned into a nearly sorted state.
     * @param size the length of the linked list parameter
     * @param unsortedness the percentage unsortedness of the list required.
     */
    private static LinkedList<Integer> nearlySort(LinkedList<Integer> linkedList, int size, double unsortedness) {
        double numberOfElements = unsortedness * size;

        Random random = new Random();
        LinkedList<Integer> newList = new LinkedList<>();
        for (int i = 0; i < numberOfElements; i++) {
            newList.add(linkedList.remove(random.nextInt(linkedList.size())));
        }
        newList.addAll(linkedList);
        return newList;
    }

    private static void writeList(LinkedList<Integer> linkedList, String outputFilename) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilename));
            for (int i: linkedList) {
                writer.print(i + " ");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        double[] unsortednessValue = {0.02, 0.04, 0.06, 0.08, 0.1};

        for (double i : unsortednessValue) {
            LinkedList<Integer> linkedList = readList();
            linkedList = nearlySort(linkedList, linkedList.size(), i);
            int Integer = (int) (i * 100);
            String outputFileName = "TestLists/NearlySorted" + Integer + ".txt";
            writeList(linkedList, outputFileName);
        }
    }
}
