package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

            allLines = readData(new BufferedReader(new InputStreamReader(System.in)).readLine());
            forRemoveLines = readData(new BufferedReader(new InputStreamReader(System.in)).readLine());

            Solution solution = new Solution();
            try {
                solution.joinData();
            } catch (CorruptedDataException e) {
            }
        }

    public static List<String> readData(String fileName) throws IOException {
        List <String> fu = new ArrayList<>();
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        while (in.ready()) {
            fu.add(in.readLine());
    }
        in.close();
        return fu;
    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {allLines.clear();
        throw new CorruptedDataException();
        }
    }
}
