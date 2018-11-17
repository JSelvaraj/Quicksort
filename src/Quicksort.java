import java.io.*;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Scanner;

public class Quicksort {

    static long swaps;

    public static LinkedList<Integer> sort(LinkedList<Integer> array) {
        LinkedList<Integer> less = new LinkedList<>();
        LinkedList<Integer> more = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();

        if (array.size() > 1) {
            int pivot = array.getLast();
            for (int i: array) {
                if (i < pivot) {
                    swaps++;
                    less.add(i);
                } else if (i == pivot) {
                    swaps++;
                    equal.add(i);
                } else if (i > pivot) {
                    swaps++;
                    more.add(i);
                }
            }
            less = sort(less);
            more = sort(more);
            less.addAll(equal);
            less.addAll(more);
            return less;
        } else {
            return array;
        }
    }

    public static long getTime (LinkedList<Integer> array) {

        long startTime = System.currentTimeMillis();
        array = sort(array);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;


    }

    public static void main (String args[]) {

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("output.txt"));
            for (int i = 0; i < 40; i++) {

                    File input = new File("Input.txt");
                    Scanner scanner = new Scanner(input);

                    LinkedList<Integer> linkedList = new LinkedList<>();
                    while (scanner.hasNext()) {
                        linkedList.add(scanner.nextInt());
                    }

                    long timeTaken = getTime(linkedList);
                    int time = (int) timeTaken;
                    writer.println("#" + i + " Time Taken: " + Integer.toString(time) + "  Swaps: " + swaps);
                    writer.println();
                    writer.flush();
                    swaps = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

