package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
     Map <String, Integer> createMap = new HashMap <String, Integer> ();
     createMap.put("Вася", 120);
     createMap.put("Петя", 200);
     createMap.put("Женя", 1200);
     createMap.put("Василиса", 12000);
     createMap.put("Мура", 10200);
     createMap.put("Дура", 120070);
     createMap.put("Фура", 10);
     createMap.put("Люся", 1);
     createMap.put("Дуся", 12);
     createMap.put("Муся", 100);
    return createMap;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
    Iterator <Map.Entry<String, Integer>> iter = map.entrySet().iterator();
    while(iter.hasNext()){
        Map.Entry<String, Integer> entry = iter.next();
        if (entry.getValue()<(Integer) 500){
        iter.remove ();
        }
        }
    return;
    }

    public static void main(String[] args) {

    }
}