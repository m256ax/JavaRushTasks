package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
    Map createMap = new HashMap <String, String> ();
        createMap.put("Сергеев", "Антон");
        createMap.put("Иванов", "Петя");
        createMap.put("Стаханов", "Жора");
        createMap.put("Сталин", "Иосиф");
        createMap.put("Куриев", "Артур");
        createMap.put("Сколов", "Антон");
        createMap.put("Воробев", "Станичлав");
        createMap.put("Сергеева", "Антон");
        createMap.put("Глодин", "Паша");
        createMap.put("Кинг", "Стивен");
        return createMap;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for(Map.Entry<String, String> s : map.entrySet()){
            if (s.getValue().equals(name)){
            count++;
        }
        }
        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for(Map.Entry<String, String> s : map.entrySet()){
            if (s.getKey().equals(lastName)){
            count++;
        }
        }
        return count;
    }

    public static void main(String[] args) {
    }
}
