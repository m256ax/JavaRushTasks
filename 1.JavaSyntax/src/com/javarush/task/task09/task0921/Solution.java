package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List <Integer> list = new ArrayList<Integer>();
        try {
        while (true) {

                list.add(Integer.parseInt(reader.readLine()));

        }

        } catch (IOException | NumberFormatException e) {    }
            finally {
            for (int i = 0; i<list.size(); i++){
                System.out.println(list.get(i));
            }
        }
    }
}
