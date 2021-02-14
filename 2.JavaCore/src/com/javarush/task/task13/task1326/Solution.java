package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String name = reader.readLine();
        BufferedReader inStream = new BufferedReader (new InputStreamReader(new FileInputStream(name)));
        ArrayList<Integer> number = new ArrayList<>();
        while(inStream.ready()) {
            int a = Integer.parseInt(inStream.readLine());
                if(a%2==0) {
                    number.add(a);
                }
        }
        Collections.sort(number);

        for (Integer num: number) {
            System.out.println(num);
        }

        reader.close();
        inStream.close();;
    }
}
