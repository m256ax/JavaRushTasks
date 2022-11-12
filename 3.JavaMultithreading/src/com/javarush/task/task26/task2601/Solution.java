package com.javarush.task.task26.task2601;

/*
Почитать в инете про медиану выборки
*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
//        Integer[]array = new Integer[]{13, 8, 15, 5, 17};
//        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
        int med = 0;
        if (array.length%2!=0) med = array[array.length/2];
        else {
            double min = array[(array.length/2)-1];
            double max = array[array.length/2];
            med = (int) Math.round ((Math.abs(max) + Math.abs(min)) / 2);
        }
//        System.out.println(med);
        final int m = med;

//        int temp = 0;
//        for (int i = 0; i< array.length; i++){
//            for (int j = 1; j < array.length; j++){
//                if (Math.abs(med - array[j]) <= Math.abs(med - array[j-1])){
//                    temp = array[j];
//                    array[j]=array[j-1];
//                    array[j-1]=temp;
//                }
//            }
//        }
//    return array;
        Comparator <Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(m - o1) > Math.abs(m - o2))
                    return 1;
                else if (Math.abs(m - o1) < Math.abs(m - o2))
                return -1;
                else return 0;
            }
        };
        Arrays.sort(array,comp);
        return array;
    }
}
