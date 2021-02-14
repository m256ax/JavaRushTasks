package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();
        String line;
        while (!((line=reader.readLine())==null)) {
            String[]str = line.split("\\s");
            if(map.containsKey(str[0])) {map.replace(str[0],map.get(str[0]), map.get(str[0]) + Double.parseDouble(str[1]));}
            else map.put(str[0], Double.parseDouble(str[1]));
        }
        reader.close();
        Double max=0.0;
        for(Map.Entry<String, Double> entry:map.entrySet()){
            if(entry.getValue()>max) max=entry.getValue();
        }

        for(Map.Entry<String, Double> entry:map.entrySet()){
            if(entry.getValue().equals(max)) System.out.println(entry.getKey());
        }
    }
}
