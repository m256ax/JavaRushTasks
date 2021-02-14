package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileWriter fileWriter = new FileWriter(file, true);
        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        int maxId = 0;

        while (fileReader.ready()) {
            int id = Integer.parseInt(fileReader.readLine().substring(0,8).trim());
            if (maxId < id) maxId = id;
        }

        fileReader.close();

        if (args.length!=0&&args[0].equals("-c")) {
            String productName;
            String productNameEnd = "";
            String price = args[args.length-2];
            String quantity = args[args.length-1];
            StringBuilder sb = new StringBuilder();

            if (args[args.length-1].length()>4&&args[args.length-1].length()<13) {
                price = args[args.length-1].substring(0,9);
                quantity = args[args.length-1].substring(9,13);
            }

            if (args[args.length-1].length()>12) {
                String priceFoo = args[args.length-1].replaceAll("^\\D+","");
                price = priceFoo.substring(0,8);
                quantity = priceFoo.substring(8);
                productNameEnd = args[args.length-1].replaceAll("\\d*.\\d+$", "");

                for (int i = 2; i < args.length - 1; i++) {
                    sb.append(args[i] + " ");
                }
            }

            if (args[args.length-1].length()<=4&& args[args.length-2].length()>8) {
                productNameEnd = args[args.length - 2].replaceAll("\\d*.\\d+$", "");

                price = args[args.length-2].replaceAll("^\\D+","");

                quantity = args[args.length-1];

                for (int i = 2; i < args.length - 2; i++) {
                    sb.append(args[i] + " ");
                }
            }

            if (args[args.length-1].length()<=4&& args[args.length-2].length()<=8) {
                for (int i = 2; i < args.length - 2; i++) {
                    sb.append(args[i] + " ");
                }
            }

                productName = args[1] + " " + sb.toString() + productNameEnd;

            String out = String.format("%-8d%-30.30s%-8.8s%-4.4s",maxId+1, productName.trim(), price, quantity);
            fileWriter.write("\n");
            fileWriter.write(out);

            fileWriter.close();
        }
    }
}
