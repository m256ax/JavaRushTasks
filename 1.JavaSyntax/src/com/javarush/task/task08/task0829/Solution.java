package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap <String, String>();
        while (true) {
            String city = reader.readLine();
            if (city.isEmpty()) break;
            String family = reader.readLine();
            map.put(city, family);
            
        }

        String city = reader.readLine();


        for (Map.Entry<String, String> s : map.entrySet()) {
        if (s.getKey().equals(city)) {
            System.out.println(s.getValue());
        }
    }
    }
}
