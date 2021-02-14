package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        try {
            firstFileName = new BufferedReader (new InputStreamReader(System.in)).readLine();
            secondFileName = new BufferedReader (new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        String fullFileName;
        ArrayList <String> list = new ArrayList<>();

        @Override
        public void run() {
                try {
                    BufferedReader content = new BufferedReader(new FileReader(fullFileName));
                    while (content.ready()) {
                        list.add(content.readLine() + " ");
                    }
                    content.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            String str="";
            for (String s:list) {
                str+=s;
            }
            return str;
        }
    }
}