package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        String[] arr = fileReader.readLine().split("\\s");
        fileReader.close();
        StringBuilder result = getLine(arr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) {
            return new StringBuilder();
        }

        List<String> list = new ArrayList<>(Arrays.asList(words));

        String result = list.get(0)+" ";
        list.remove(0);

        int count = 0;
        while(!list.isEmpty()){
            count++;
            if (count==words.length*2) {
                Collections.sort(list);
                for (String s : list) {
                    result = result + s + " ";
                }
                break;
            }
            if (result.toLowerCase().charAt(0)==list.get(0).toLowerCase().charAt(list.get(0).length()-1)) {
                result = list.get(0) + " " + result;
                list.remove(0);
            } else if (result.toLowerCase().charAt(result.length()-2)==list.get(0).toLowerCase().charAt(0)) {
                result = result  + list.get(0) + " ";
                list.remove(0);
            } else {
                list.add(list.get(0));
                list.remove(0);
            }
        }
        return new StringBuilder(result);
    }
}