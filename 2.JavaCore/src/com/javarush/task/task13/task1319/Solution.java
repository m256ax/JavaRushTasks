package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args)throws java.io.IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String file = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

    String line = reader.readLine();

    while (!line.isEmpty()) {
        writer.write(line + "\n");
        if (line.equals("exit")) {break;}
        line = reader.readLine();
    }
    writer.close();
    reader.close();
    }
}
