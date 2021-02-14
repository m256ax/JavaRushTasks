package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map map = new HashMap <String, String> ();
        map.put ("Иванов", "Иван");
        map.put ("Иванов", "Петр");
        map.put ("Петров", "Евгений");
        map.put ("Сидоров", "Сидор");
        map.put ("Селюнин", "Евгений");
        map.put ("Терентьев", "Александр");
        map.put ("Щеблов", "Сергей");
        map.put ("Головачев", "Георгий");
        map.put ("Здерев", "Иоан");
        map.put ("Лысенко", "Владимир");

        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
