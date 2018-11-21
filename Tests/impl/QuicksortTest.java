package impl;

import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuicksortTest {
    private static final int NUMBER_OF_TESTS = 20;
    private static final double MAX_UNSORTEDNESS = 0.41;

    private static int listSize = 4000;
    private static String exchangeTimeDoc = "";
    private static String exchangeComparisonDoc = "";
    private static String removalTimeDoc = "";
    private static String removalComparisonDoc = "";

    @Test
    public void A_sorted() {
        exchangeTimeDoc += "Sorted List, ";
        exchangeComparisonDoc += "Sorted List, ";
        removalTimeDoc += "Sorted List, ";
        removalComparisonDoc += "Sorted List, ";
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
            Collections.sort(arrayList);
            long time = Quicksort.getTime(arrayList);
            exchangeTimeDoc += time + ",";
            exchangeComparisonDoc += Quicksort.getSwaps() + ",";
            removalTimeDoc += time + ",";
            removalComparisonDoc += Quicksort.getSwaps() + ",";
        }
    }

//    @Test
//    public void B_nearlySortedExchange() {
//        for (double i = 0.02; i < MAX_UNSORTEDNESS; i += 0.02) {
//            int percentage = (int) (i * 100);
//
//            document += "\n" + percentage + "% out of order, Exchange (ms):, ";
//            swapsDoc += "\n" + percentage + "% out of order, Exchange (ms):, ";
//            for (int k = 0; k < NUMBER_OF_TESTS; k++) {
//                ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
//                Collections.sort(arrayList);
//                arrayList = NearlySorted.exchange(arrayList, arrayList.size(), i);
//                document += Quicksort.getTime(arrayList) + ",";
//                swapsDoc += Quicksort.getSwaps() + ",";
//            }
//        }
//    }

    @Test
    public void C_nearlySortedExchange2() {
        for (int i = 10; i < listSize; i += 10) {
            if (i > 100) {
                i += 90;
            }
            exchangeTimeDoc += "\n" + i + ",";
            exchangeComparisonDoc += "\n" + i + " ,";
            for (int k = 0; k < NUMBER_OF_TESTS; k++) {
                ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
                Collections.sort(arrayList);
                arrayList = NearlySorted.exchange(arrayList, i);
                exchangeTimeDoc += Quicksort.getTime(arrayList) + ",";
                exchangeComparisonDoc += Quicksort.getSwaps() + ",";
            }
        }
    }

//    @Test
//    public void D_nearlySortedRemoval() {
//        for (double i = 0.02; i < MAX_UNSORTEDNESS; i += 0.02) {
//            int percentage = (int) (i * 100);
//            swapsDoc += "\n" + percentage + "% out of order, Removal (ms):, ";
//            document += "\n" + percentage + "% out of order, Removal (ms):, ";
//            for (int k = 0; k < NUMBER_OF_TESTS; k++) {
//                ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
//                Collections.sort(arrayList);
//                arrayList = NearlySorted.removal(arrayList, arrayList.size(), i);
//                document += Quicksort.getTime(arrayList) + ",";
//                swapsDoc += Quicksort.getSwaps() + ",";
//            }
//        }
//    }

    @Test
    public void E_nearlySortedRemoval2() {
        for (int i = 10; i < listSize; i += 10) {
            if (i < listSize - 100) {
                i += 90;
            }
            removalTimeDoc += "\n" + i + ",";
            removalComparisonDoc += "\n" + i + ",";
            for (int k = 0; k < NUMBER_OF_TESTS; k++) {
                ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
                Collections.sort(arrayList);
                arrayList = NearlySorted.removal(arrayList, i);
                removalTimeDoc += Quicksort.getTime(arrayList) + ",";
                removalComparisonDoc += Quicksort.getSwaps() + ",";
            }
        }
    }


    @Test
    public void F_randomOrder() {
        exchangeTimeDoc += "\nRandom Order, ";
        exchangeComparisonDoc += "\nRandom Order:, ";
        removalTimeDoc += "\nRandom Order:, ";
        removalComparisonDoc += "\nRandom Order, ";
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
            long time = Quicksort.getTime(arrayList);
            exchangeTimeDoc += time + ",";
            exchangeComparisonDoc += Quicksort.getSwaps() + ",";
            removalTimeDoc += time + ",";
            removalComparisonDoc += Quicksort.getSwaps() + ",";
        }
    }

    @Test
    public void G_reverseOrder() {
        exchangeTimeDoc += "\nReverse Sorted List, ";
        exchangeComparisonDoc += "\nReverse Sorted List, ";
        removalTimeDoc += "\nReverse Sorted List, ";
        removalComparisonDoc += "\nReverse Sorted List, ";
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {
            ArrayList<Integer> arrayList = GenerateList.makeList(listSize);
            Collections.reverse(arrayList);
            long time = Quicksort.getTime(arrayList);
            exchangeTimeDoc += time + ",";
            exchangeComparisonDoc += Quicksort.getSwaps() + ",";
            removalTimeDoc += time + ",";
            removalComparisonDoc += Quicksort.getSwaps() + ",";
        }
    }






    @AfterClass
    public static void print() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("ExchangeTime.csv"),true);
            PrintWriter writer1 = new PrintWriter(new FileWriter("ExchangeComp.csv"),true);
            PrintWriter writer2 = new PrintWriter(new FileWriter("RemovalTime.csv"),true);
            PrintWriter writer3 = new PrintWriter(new FileWriter("RemovalComp.csv"),true);
            writer.println(exchangeTimeDoc);
            writer1.println(exchangeComparisonDoc);
            writer2.println(removalTimeDoc);
            writer3.println(removalComparisonDoc);
            writer1.flush();
            writer.flush();
            writer1.close();
            writer.close();
            writer2.close();
            writer3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}