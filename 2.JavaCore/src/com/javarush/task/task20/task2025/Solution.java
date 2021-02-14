package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long getN) {
        if (getN <= 1) return new long[0];
        long[] result = null;
        int maxN = Long.toString(getN).length();

        long[][] pows = new long[10][maxN + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }

        List<Long> results = new ArrayList<>();
        int[] digitsMultiSet = new int[10];
        int[] testMultiSet = new int[10];
        long maxPow;
        long minPow;
        int N = 0;
        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);

            search(9, N, 0, maxPow, minPow, results, digitsMultiSet, N, testMultiSet, pows, getN);
        }
        Collections.sort(results);

        if (results.size() > 0) {
            result = new long[results.size()];
            for (int i = 0; i < results.size(); i++) {
                result[i] = results.get(i);
            }
        }
        return result;
    }

    private static void search(int digit, int unused, long pow, long maxPow, long minPow, List<Long> results, int[] digitsMultiSet, int N, int[] testMultiSet, long[][] pows, long getN) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow, maxPow, minPow, digitsMultiSet, testMultiSet) && pow < getN) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N], maxPow, minPow, results, digitsMultiSet, N, testMultiSet, pows, getN);
        } else {
            // Check if we can generate more than minimum
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p, maxPow, minPow, results, digitsMultiSet, N, testMultiSet, pows, getN);
                if (i != unused) {
                    p += pows[digit][N];
                }
            }
        }
    }

    private static boolean check(long pow, long maxPow, long minPow, int[] digitsMultiSet, int[] testMultiSet) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long[] array = getNumbers(Long.MAX_VALUE);
        long end = System.currentTimeMillis() - start;
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Time = " + end);
        System.out.println("Memory = " + memory / 1048576);
        int count = 1;
        for (long k : array)

            System.out.print(count++ + " = " + k + "   ");
    }
}