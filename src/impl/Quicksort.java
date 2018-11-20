package impl;


import java.util.ArrayList;


public class Quicksort {

    private static long swaps;

    public static ArrayList<Integer> sort(ArrayList<Integer> array) {
        ArrayList<Integer> less = new ArrayList<>();
        ArrayList<Integer> more = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();

        if (array.size() > 1) {
            int pivot = array.get(array.size()-1);
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

    public static long getTime (ArrayList<Integer> array) {
        swaps = 0;
        long startTime = System.nanoTime();
        array = sort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;
    }

    public static long getSwaps() {
        return swaps;
    }

    public static long getSwaps( ArrayList<Integer> arrayList) {
        swaps = 0;
        arrayList = sort(arrayList);
        return swaps;
    }

}

