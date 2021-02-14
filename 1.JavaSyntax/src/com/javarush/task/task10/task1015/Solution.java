package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Collections;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList <String> [] createList = new ArrayList [3];
        createList [0] = new ArrayList <> ();
        createList [1] = new ArrayList <>();
        createList [2] = new ArrayList <>();
        Collections.addAll(createList[0],"fgfg");
        Collections.addAll(createList[1],"fgfgere");
        Collections.addAll(createList[2],"fgftrztg");

        return createList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}