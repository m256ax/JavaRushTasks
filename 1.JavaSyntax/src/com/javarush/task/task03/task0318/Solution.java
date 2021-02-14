package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt ();
    String name = scanner.next ();
    System.out.print (name);
    System.out.print (" захватит мир через " +( a + " лет. Му-ха-ха!"));

    }
}
