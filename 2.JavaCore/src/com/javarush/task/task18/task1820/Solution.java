package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileWriter outputStream = new FileWriter(reader.readLine());

        Scanner scanner = new Scanner(inputStream);

        String str = scanner.nextLine();

        inputStream.close();

        String[] num = str.split(" ");

        for (int s=0; s<num.length; s++) {
            outputStream.write(Math.round(Double.parseDouble(num[s])) + " ");
        }

        outputStream.close();
    }
}
