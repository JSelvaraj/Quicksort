import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class Quicksort {

    public static LinkedList<Integer> sort(LinkedList<Integer> array) {
        LinkedList<Integer> less = new LinkedList<>();
        LinkedList<Integer> more = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();

        if (array.size() > 1) {
            int pivot = array.getFirst();
            for (int i: array) {
                if (i < pivot) {
                    less.add(i);
                } else if (i == pivot) {
                    equal.add(i);
                } else if (i > pivot) {
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


    }

    public static void main (String args[]) {

        File input = new File("Input.txt");
        Scanner scanner = new Scanner(input);

        LinkedList<Integer> linkedList = new LinkedList<>();
        while (scanner.hasNext()) {
            linkedList.add(scanner.nextInt());
        }

    }
}

