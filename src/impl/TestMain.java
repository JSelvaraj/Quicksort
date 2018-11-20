package impl;

import bin.LIS;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class TestMain {

    private static final int NUMBER_OF_TESTS = 10;


    private static int listSize = 10000;


    public static void main(String args[]) {
        if (args.length == 1) {
            try {
                listSize = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        randomOrder();
        inOrder();
        nearlySorted();
        reverseOrder();

    }


    private static void randomOrder() {
        LinkedList<Integer> linkedList;
        try {
            linkedList = GenerateList.makeList(listSize);
            PrintWriter writer = new PrintWriter(new FileWriter("Results.csv"), true);

            int[] array = new int[linkedList.size()];
            for (int i = 0; i < linkedList.size(); i++) {
                array[i] = linkedList.get(i);
            }
            double sortednessRatio = ((double) LIS.LongestIncreasingSubsequenceLength(array, linkedList.size()) / linkedList.size()) * 100;
            String ratio = Double.toString(sortednessRatio);
            try {
                ratio = ratio.substring(0, 4);
            } catch (Exception e) {
                ratio = ratio.substring(0, 3);
            }
            writer.println("Random Order(" + ratio + "% sorted)(ms):, ");
            writer.flush();
            for (int i = 0; i < NUMBER_OF_TESTS; i++) {
                writer.print(Quicksort.getTime(linkedList) + ",");
                if (i == NUMBER_OF_TESTS - 2) {
                    Quicksort.resetSwaps();
                }
            }
            writer.flush();
            writer.println();
            writer.println("Number of Swaps:, " + Quicksort.getSwaps());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inOrder() {
        try {
            LinkedList<Integer> linkedList = GenerateList.makeList(listSize);
            Collections.sort(linkedList);
            PrintWriter writer = new PrintWriter(new FileWriter("Results.csv", true), true);

            writer.print("Sorted List(ms):, ");
            writer.flush();
            for (int i = 0; i < NUMBER_OF_TESTS; i++) {
                writer.print(Quicksort.getTime(linkedList) + ",");
                if (i == NUMBER_OF_TESTS - 2) {
                    Quicksort.resetSwaps();
                }
            }
            writer.flush();
            writer.println();
            writer.println("Number of Swaps:, " + Quicksort.getSwaps());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nearlySorted() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("Results.csv", true), true);
            for (double i = 0.02; i < 0.51; i += 0.02) {
                ArrayList<Long> swaps = new ArrayList<>();
                for (int k = 0; k < 5; k++) {
                    LinkedList<Integer> linkedList = GenerateList.makeList(listSize);
                    Collections.sort(linkedList);
                    linkedList = NearlySorted.nearlySort(linkedList, linkedList.size(), i);
                    int percentage = (int) (i * 100);
                    writer.println();
                    writer.print(percentage + "% out of order [Test List No." + (k + 1) + "](ms):, ");
                    writer.flush();
                    for (int j = 0; j < NUMBER_OF_TESTS; j++) {
                        writer.print(Quicksort.getTime(linkedList) + ",");
                        writer.flush();
                        if (j == NUMBER_OF_TESTS - 2) {
                            Quicksort.resetSwaps();
                        } else if (j == NUMBER_OF_TESTS - 1) {
                            swaps.add(Quicksort.getSwaps());
                        }
                    }
                }
                writer.println();
                writer.println("Number of Swaps:, " + swaps);
                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void reverseOrder() {
        try {
            LinkedList<Integer> linkedList = GenerateList.makeList(listSize);
            Collections.reverse(linkedList);
            PrintWriter writer = new PrintWriter(new FileWriter("Results.csv", true), true);
            writer.print("Reverse Order List (ms):, ");
            writer.flush();
            for (int i = 0; i < NUMBER_OF_TESTS; i++) {
                writer.print(Quicksort.getTime(linkedList) + ",");
                if (i == NUMBER_OF_TESTS - 2) {
                    Quicksort.resetSwaps();
                }
            }
            writer.flush();
            writer.println();
            writer.println("Number of Swaps:, " + Quicksort.getSwaps());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
