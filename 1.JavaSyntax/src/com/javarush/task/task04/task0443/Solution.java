package com.javarush.task.task04.task0443;

/* 
Как назвали, так назвали
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        String aName = reader.readLine();
        String aY = reader.readLine();
        int y = Integer.parseInt(aY);
        String aM = reader.readLine();
        int m = Integer.parseInt(aM);
        String aD = reader.readLine();
        int d = Integer.parseInt(aD);

        System.out.println("Меня зовут " + aName+".");
        System.out.println("Я родился " + d + "."+m+"."+y);


    }
}
