package com.javarush.task.task05.task0507;

import java.util.*;
/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
       Scanner reader= new Scanner (System.in);
       int count=0;
       double sum=0;
        while (true) {
            double number = reader.nextDouble();
            if (number==-1)
            {break;}
            sum=sum+number;
            count++;
        }
        System.out.println(sum/count);
    }
}

