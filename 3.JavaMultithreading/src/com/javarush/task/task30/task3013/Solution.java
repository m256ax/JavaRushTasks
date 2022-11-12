package com.javarush.task.task30.task3013;

/* 
Битовые операции
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
//        System.sout.println("0" + Integer.toBinaryString(number>>1));
        number |= number >> 1;
//        System.out.println(Integer.toBinaryString(number));
//        System.out.println("00" + Integer.toBinaryString(number>>2));
        number |= number >> 2;
//        System.out.println(Integer.toBinaryString(number));
//        System.out.println("0000" + Integer.toBinaryString(number>>4));
        number |= number >> 4;
//        System.out.println(Integer.toBinaryString(number));
//        System.out.println("00000000" + Integer.toBinaryString(number>>8));
        number |= number >> 8;
//        System.out.println(Integer.toBinaryString(number));
//        System.out.println("0000000000000000" + Integer.toBinaryString(number>>16));
        number |= number >> 8;
        number |= number >> 8;
//        System.out.println(Integer.toBinaryString(number));
//        System.out.println("0" + Integer.toBinaryString(number>>1));
        number &= ~number >> 1;
        return number;
    }
}