package com.javarush.task.task04.task0439;

/* 
Письмо счастья
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       String aName = reader.readLine();

       for (int a=1; a<=10;a++)
       {
           System.out.println(aName + " любит меня.");
       }
    }
}
