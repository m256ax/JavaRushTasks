package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int a) {
        //напишите тут ваш код
        System.out.print(a + " = ");
            StringBuilder s = new StringBuilder();

            while (a > 0) {
                int q = a / 3;
                int r = a % 3;
                if (r <= 1) {
                    s = s.append ("+" + r + " ");
                    a = q;
                }
                else {
                    r = 3 - r;
                    s =  s.append("-" + r + " ");
                    a = q + 1;
                }
            }

            String [] arr = s.toString().split(" ");

        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("0")) continue;
            else if (arr[i].contains("-"))System.out.print("- ");
                else System.out.print("+ ");
                System.out.print((int) Math.pow(3, i) + " ");
            }
        }
}
