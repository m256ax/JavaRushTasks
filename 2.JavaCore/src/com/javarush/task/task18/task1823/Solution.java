package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!(name = reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(name);
            readThread.start();
        }
    }

    public static class ReadThread extends Thread {
         String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int[] buf = new int[256];
            int max = 0;
            int res = 0;
            try {
                FileInputStream inputStream = new FileInputStream(fileName);

                while (inputStream.available() > 0) {
                    buf[inputStream.read()]++;
                }
                inputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < buf.length; i++) {
                if (max < buf[i]) {
                    max = buf[i];
                    res = i;
                }
            }
            resultMap.put(fileName, res);
        }
    }
}
