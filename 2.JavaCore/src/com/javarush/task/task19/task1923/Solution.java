package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        FileWriter writer = new FileWriter(args[1]);
        String line;
        while(!((line=reader.readLine())==null)) {
            String[] str = line.split("\\s");
            for(String s:str) {
                if(s.matches("^(?U)\\D*\\d.*$")) {
                    writer.write(s);
                    writer.write(" ");
                }
            }
        }
        reader.close();
        writer.close();
    }
}
