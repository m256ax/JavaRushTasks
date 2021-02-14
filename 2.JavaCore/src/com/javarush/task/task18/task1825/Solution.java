package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new TreeSet<>();
        String name;
        String lastName=null;
        while (!(name=reader.readLine()).equals("end")) {
            set.add(name);
            lastName = name.replaceAll("\\.part\\d+", "");
        }
        reader.close();

        FileOutputStream outputStream = new FileOutputStream(lastName);

        for (String s: set ) {
            FileInputStream inputStream = new FileInputStream(s);
            byte [] buf = new byte[inputStream.available()];
            inputStream.read(buf);
            outputStream.write(buf);
            inputStream.close();
        }
        outputStream.close();
    }
}
