package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
    ArrayList<Integer> large = new ArrayList<Integer>();
    ArrayList<Integer> small3 = new ArrayList <Integer>();
    ArrayList<Integer> small2 = new ArrayList <Integer>();
    ArrayList<Integer> end = new ArrayList <Integer> ();
    for (int i=0; i<20; i++) {
        large.add (Integer.parseInt(reader.readLine()));
        if (large.get(i)%3==0&&large.get(i)%2==0) {
            small3.add(large.get(i));
            small2.add(large.get(i));
        }
        else if (large.get(i)%3==0) {
            small3.add(large.get(i));
        }
       
        else if (large.get(i)%2==0) {
            small2.add(large.get(i));
        }
        else {
            end.add(large.get(i));
        }
    }
    
    
    printList(small3);
    printList(small2);
    printList(end);
    }

    public static void printList(ArrayList<Integer> list) {
    for (int element: list) {
        System.out.println(element);
    }
    }
}
