package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nA = reader.readLine();
        String nB = reader.readLine();
        String nC = reader.readLine();
        int a = Integer.parseInt(nA);
        int b = Integer.parseInt(nB);
        int c = Integer.parseInt(nC);

        if (a==b)
        {
            System.out.println(3);
        }
        else if (b==c)
        {
            System.out.println(1);
        }
        else if (a==c)
        {
            System.out.println(2);
        }

    }
}
