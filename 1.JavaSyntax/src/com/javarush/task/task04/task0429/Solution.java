package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nA = reader.readLine();
        int a = Integer.parseInt(nA);
        String nB = reader.readLine();
        int b = Integer.parseInt(nB);
        String nC = reader.readLine();
        int c = Integer.parseInt(nC);
        int plus = 3;
        int minus = 0;
        int nu = 0;

        if (a == 0) {
            nu++;
        }
        if (b==0) {
            nu++;
        }
        if (c==0) {
            nu++;
        }

        if (a < 0) {
        minus++;
        }
        if (b<0) {
            minus++;
        }
        if (c<0) {
            minus++;
        }
        System.out.println("количество отрицательных чисел: " + minus);
        System.out.println("количество положительных чисел: " + (plus-minus-nu));

    }
}
