package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap <String, Integer> map = new HashMap<>();
        String s, name;
        int id;
        
        while (true) {
            s = reader.readLine();                                                                                                                                                                                                                                                          
            name = reader.readLine(); 

            if (s.equals("")) {break;}

                id = Integer.parseInt(s);

        if (name.equals("")){
            map.put ("", id);
            break;
        }
            map.put (name, id);
        }
        
        for (HashMap.Entry<String, Integer> pair:map.entrySet())
        {
        	                                                                                                    
        System.out.println(pair.getValue()+" "+pair.getKey());
        }
          

    }
}
