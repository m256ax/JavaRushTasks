package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String nA = reader.readLine();
       int a = Integer.parseInt(nA);
       String nS = reader.readLine();
       int s = Integer.parseInt(nS);
       String nD = reader.readLine();
       int d = Integer.parseInt(nD);

       if (a<=0&&s<=0&&d<=0) {
           System.out.println(0);
       }
        else if (a>0&&s>0&&d>0)
           {
               System.out.println(3);
           }
        else if ((a>0&&s>0)||(a>0&&d>0)||(s>0&&d>0))
       {
           System.out.println(2);
       }
        else {
           System.out.println(1);
       }
    }
}
