package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String aA = reader.readLine();
    int a= Integer.parseInt(aA);
    String aB = reader.readLine();
    int b = Integer.parseInt(aB);
    String aC = reader.readLine();
    int c = Integer.parseInt(aC);
    
    int z, x, v;
    z = Math.min (a, Math.min(b,c));
    x = Math.max(a,Math.max(b,c));
    v = (a+b+c)- (z+x);
    if (a==b&&b==c)
    {
        System.out.println(a);
    } else 
    {
        System.out.println (v);
    }

    }
}
