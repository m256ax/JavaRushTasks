package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Scanner scanner = new Scanner(inputStream);

        List <String> array = new ArrayList<>();

        while (scanner.hasNext()) {
            array.add(scanner.nextLine());
        }

        reader.close();
        inputStream.close();

        for (String s :array ) {
            String foo = s.replaceAll("\\s.*$", "");
            if (Integer.parseInt(foo)==Integer.parseInt(args[0])) System.out.println (s);
        }
    }
}
