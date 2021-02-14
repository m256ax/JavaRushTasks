package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        URL aurl = null;
        try {
            aurl = new URL(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer str = null;
        String parts = aurl.getQuery();
        System.out.println(parts);
            if (parts.contains("&")){
                char [] list = parts.toCharArray();

                for (int j=0; j<list.length; j++) {
                    while (Objects.equals(list[j], "=")) {
                        str.append(list[j]);
                    }
                        System.out.print (str);
                    }
            }
            if (parts.contains("obj")){
                System.out.println("obj");
            }

//        for (int i = 1; i < parts.length; i++) {
//            if (parts[i].contains("&")) {
//                String name = parts[i].substring(parts[i].indexOf("&") + 1);
//
//                if (name.contains("&")) {
//                    name1 = name.substring(name.indexOf("&") + 1);
//                }
//                System.out.println(name + " " + name1);
//            }
//        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

}

