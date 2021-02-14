package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
//        PrintWriter pR = new PrintWriter(outputStream);
//        StringBuilder sB = new StringBuilder();
//        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
//            sB = sB.append(entry.getKey()).append("=").append(entry.getValue());
//            pR.println(sB.toString());
//        }
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream,null);
        outputStream.flush();
        outputStream.close();
//
//        pR.flush();
//        pR.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
//        BufferedReader bR = new BufferedReader(new InputStreamReader(inputStream));
//        while (bR.ready()) {
//            String string = bR.readLine();
//            if(string.contains("=")) {
//                String[] str = string.split("=");
//                runtimeStorage.put(str[0].trim(), str[1].trim());
//            }
//        }
//        bR.close();

        Properties properties = new Properties();
        properties.load(inputStream);
        properties.forEach((k,v)->runtimeStorage.put((String) k, (String) v));

    }

        public static void main (String[]args){
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 FileInputStream fos = new FileInputStream(reader.readLine())) {
                load(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(runtimeStorage);
        }
    }
