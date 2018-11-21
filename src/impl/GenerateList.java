package impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class GenerateList {

    private static final int UPPER_BOUND = 10000;

    public static ArrayList<Integer> makeList(int size) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(UPPER_BOUND));
        }
        return arrayList;
    }

}
