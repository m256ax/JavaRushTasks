package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        Map<String,Double> arr= new TreeMap<>();
        while(!((line=reader.readLine())==null)) {
            String[] str = line.split("\\s");
            if(arr.containsKey(str[0])) {arr.replace(str[0],arr.get(str[0]),arr.get(str[0])+Double.parseDouble(str[1]));}
            else arr.put(str[0], Double.parseDouble(str[1]));
        }
        reader.close();
        for (Map.Entry <String,Double> entry:arr.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
