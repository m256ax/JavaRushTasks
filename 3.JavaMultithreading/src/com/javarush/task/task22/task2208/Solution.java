package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
//    Map<String, String> foo = new HashMap<>();
//    foo.put("name", "Ivanov");
//    foo.put("country", "Ukraine");
//    foo.put("city", "Kiev");
//    foo.put("age", null);
//        System.out.println(getQuery(foo));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sB = new StringBuilder();
        for(Map.Entry entry:params.entrySet()) {
            if (entry.getValue()!=null) {
                if (sB.length() == 0) sB = sB.append(String.format("%s = '%s'", entry.getKey(), entry.getValue()));
                else sB = sB.append(String.format(" and %s = '%s'", entry.getKey(), entry.getValue()));
            }
        }
        return sB.toString();
    }
}
