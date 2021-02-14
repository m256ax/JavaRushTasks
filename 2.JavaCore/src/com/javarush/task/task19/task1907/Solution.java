package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        StringBuilder sb= new StringBuilder();;
        int data;
        int count=0;
        String end = "";
        while(fileReader.ready()) {
                data = fileReader.read();
               sb.append((char)data);
            }
        String[] line =sb.toString().split("\\p{P}");// \p{P} - все знаки припенания
        for (String str : line) {
            end = str.trim();
            if (end.contains("world")&&!end.contains("worldworld")) count++;
        }
        reader.close();
        fileReader.close();
        System.out.println(count);
    }
}
