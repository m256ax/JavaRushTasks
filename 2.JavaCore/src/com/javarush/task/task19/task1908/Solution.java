package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine(), true));
        reader.close();

         while(fileReader.ready()) {
             String str = fileReader.readLine();
             String[] line = str.split(" ");
             for (String s: line) {
                 if (s.matches("^\\d+$")) {
                     fileWriter.write(s);
                     fileWriter.write(" ");
                 }
             }
         }
         fileReader.close();
         fileWriter.close();
    }
}
