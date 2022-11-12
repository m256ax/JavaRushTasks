package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        int q = 1;
        if( n<0) q= 0;
        BigInteger temp= BigInteger.valueOf(q);
        for (int i=0; i<n; i++) {
            temp = temp.multiply(BigInteger.valueOf(i + 1));
        }
        return temp.toString();
    }
}
