package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> createList = new ArrayList<>();
        
        createList.add (new int [] {1, 2, 3, 4, 5});
        createList.add (new int [] {7, 8});
        createList.add (new int [] {4, 3, 2, 1});
        createList.add (new int [] {7, 6, 5, 4, 3, 2, 1});
        createList.add (new int [] {});
        
        return createList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
