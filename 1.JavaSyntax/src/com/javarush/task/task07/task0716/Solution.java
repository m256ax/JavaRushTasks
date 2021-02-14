package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> fix = new ArrayList<String> (strings.size());
        for (int i = 0; i<strings.size(); i++) {
            String s = strings.get(i);
            fix.add (strings.get (i));
            if (s.contains("л")&!s.contains("р")){
                fix.add(strings.get(i));
            }
            fix.removeIf (n->(n.contains("р")&!n.contains("л")));
        }
        return fix;
    }
}