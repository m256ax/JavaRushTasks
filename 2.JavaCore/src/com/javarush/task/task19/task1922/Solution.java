package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader(reader.readLine()));
        String  line;
        while(!((line=readerFile.readLine())==null)){
            int count=0;
            String [] str = line.split("\\s");
            for(String w:words) {
                for(String s:str) {
                    if (w.equals(s)) count++;
                }
            }
            if (count==2) {
                System.out.println(line);
            }
            line="";
        }
        reader.close();
        readerFile.close();
    }
}
