package impl;

import bin.LIS;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Scanner;

public class Quicksort {

    public static long swaps;

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

    public static long getSwaps() {
        return swaps;
    }

    public static void resetSwaps() {
        swaps = 0;
    }

    public static long getTime (LinkedList<Integer> array) {

        long startTime = System.nanoTime();
        array = sort(array);
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000;


    }

}

