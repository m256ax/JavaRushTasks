package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in);
      double t = scanner.nextDouble();

      if (t%5>=0&&t%5<3)
      {
          System.out.println("зеленый");
      }
else if (t%5>=3&&t%5<4)
      {
          System.out.println("желтый");
      }
else
          System.out.println("красный");

    }
}