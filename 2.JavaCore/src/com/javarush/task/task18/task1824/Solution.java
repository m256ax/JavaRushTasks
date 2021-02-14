package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)  {
        String name=null;
        boolean q = true;

        try  {
        while (q) {
                name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                FileInputStream inputStream = new FileInputStream(name);
            inputStream.close();
        }
        } catch(
                FileNotFoundException e)  {
            System.out.println(name);
            q=false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
