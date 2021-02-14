package com.javarush.task.task04.task0432;

/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String st = reader.readLine();
        String nt = reader.readLine();
        int n = Integer.parseInt(nt);
        while (n>0)
        {
            System.out.println(st);
            n--;
        }

    }
}
