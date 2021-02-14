package com.javarush.task.task14.task1420;

import java.util.*;
import java.io.*;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        if (a<=0||b<=0) throw new Exception();
        int ans = gcd(Math.abs(a), Math.abs(b));
        System.out.println(ans);
        }
        
        public static int gcd (int n1, int n2) {
    int gcd = 1;
    for (int i = 1; i <= n1 && i <= n2; i++) {
        if (n1 % i == 0 && n2 % i == 0) {
            gcd = i;
        }
    }
    return gcd;
}
        
    }

