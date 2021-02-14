package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map map = new HashMap <String, String> ();
        map.put ("Фадеев", "Петр");
        map.put ("Иванов", "Петр");
        map.put ("Петров", "Евгений");
        map.put ("Сидоров", "Сидор");
        map.put ("Селюнин", "Евгений");
        map.put ("Терентьев", "Александр");
        map.put ("Щеблов", "Сергей");
        map.put ("Головачев", "Георгий");
        map.put ("Здерев", "Евгений");
        map.put ("Лысенко", "Владимир");

        return map;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        java.util.HashSet <String> set = new java.util.HashSet <>();
        for (String name : copy.values()) {
            if (!set.add(name)) removeItemFromMapByValue(map,name);
            }
        }

        public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
    
       
    }
}

