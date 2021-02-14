package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        Map<Integer, String> map = readerFile(file);

        if (args[0] != null && args[0].equals("-u"))
        {
            upDate(getId(args[1]), makeString(args), map);
        }

        if(args[0] != null && args[0].equals("-d")) {
            delDate(getId(args[1]), map);
        }

        writerFile(file, map);
    }

    public static  Map<Integer, String> readerFile (String fileName) throws IOException{
        Map<Integer, String> map = new LinkedHashMap<>();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String str = fileReader.readLine();
            map.put(Integer.parseInt(str.substring(0, 8).trim()), str.substring(8));
        }

        fileReader.close();

        return map;
    }

    public static void writerFile (String file, Map<Integer, String> map) throws IOException{
        FileWriter fileWriter = new FileWriter(file);

        for (Map.Entry entry: map.entrySet()) {
            String fin = String.format("%-8d%-42.42s",entry.getKey(), entry.getValue());
            fileWriter.write(fin);
            fileWriter.write("\n");
        }
        fileWriter.close();
    }


    public static void upDate(Integer key, String string, Map<Integer, String > map) {

        for(Map.Entry<Integer, String> entry: map.entrySet()){
            if(entry.getKey().equals(key)) {
                entry.setValue(string);
            }
        }
    }

    public static void delDate(Integer key, Map<Integer, String > map) {
        map.remove(key);
        }

            public static String makeString(String[] args){
            String productName;
            String productNameStart = "";
            String productNameEnd = "";
            String price = args[args.length - 2];
            String quantity = args[args.length - 1];
            StringBuilder sb = new StringBuilder();
            String makeString;

            if (args[1].length() > 8) {
                productNameStart = args[1].substring(8);
            }

            if (args[args.length - 1].length() > 4 && args[args.length - 1].length() < 13) {
                price = args[args.length - 1].substring(0, 9);
                quantity = args[args.length - 1].substring(9, 13);
            }

            if (args[args.length - 1].length() > 12) {
                String priceFoo = args[args.length - 1].replaceAll("^\\D+", "");
                price = priceFoo.substring(0, 8);
                quantity = priceFoo.substring(8);
                productNameEnd = args[args.length - 1].replaceAll("\\d*.\\d+$", "");

                for (int i = 2; i < args.length - 1; i++) {
                    sb.append(args[i] + " ");
                }
            }

            if (args[args.length - 1].length() <= 4 && args[args.length - 2].length() > 8) {
                productNameEnd = args[args.length - 2].replaceAll("\\d*.\\d+$", "");

                price = args[args.length - 2].replaceAll("^\\D+", "");

                quantity = args[args.length - 1];

                for (int i = 2; i < args.length - 2; i++) {
                    sb.append(args[i] + " ");
                }
            }

            if (args[args.length - 1].length() <= 4 && args[args.length - 2].length() <= 8) {
                for (int i = 2; i < args.length - 2; i++) {
                    sb.append(args[i] + " ");
                }
            }

            productName = productNameStart + " " + sb.toString() + productNameEnd;

            makeString = String.format("%-30.30s%-8.8s%-4.4s", productName.trim(), price, quantity);

            return makeString;
        }

        public static Integer getId (String s) {
        Integer id;
            if (s.length() > 8) {
                id = Integer.parseInt(s.substring(0, 8));
            } else id = Integer.parseInt(s);
            return id;
    }
}