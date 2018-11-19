package impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;

public class GenerateList {

    private static final int UPPER_BOUND = 5000;


    public static LinkedList<Integer> makeList(int size) {
        Random random = new Random();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            linkedList.add(random.nextInt(UPPER_BOUND));
        }
        return linkedList;
    }

    public static void makeFile(LinkedList<Integer> linkedList) {
        try {
            File list = new File ("input.txt");
            PrintWriter writer = new PrintWriter(new FileWriter(list),true);
            for (int i : linkedList) {
                writer.append(i + " ");

                writer.flush();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
