package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        OurHashBiMapStorageStrategy biMapStorageStrategy = new OurHashBiMapStorageStrategy();
        DualHashBidiMapStorageStrategy dualBi = new DualHashBidiMapStorageStrategy();
        HashBiMapStorageStrategy guava = new HashBiMapStorageStrategy();
        testStrategy(hashMapStorageStrategy, 10_000);
        testStrategy(ourHashMapStorageStrategy, 10_000);
        testStrategy(fileStorageStrategy, 100);
        testStrategy(biMapStorageStrategy, 10_000);
        testStrategy(guava, 10_000);
//        testStrategy(dualBi, 10_000);

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> ids = new HashSet<>();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> strings = new HashSet<>();
        for (Long key : keys) {
            strings.add(shortener.getString(key));
        }
        return strings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        long i = 0L;
        while (i < elementsNumber) {
            strings.add(Helper.generateRandomString());
            i++;
        }

        Shortener shortener = new Shortener(strategy);
        Date date = new Date();
        long startTimer = date.getTime();

        Set<Long> ids = getIds(shortener, strings);

        Date date1 = new Date();
        long stopTimer = date1.getTime();

        System.out.println("Time in milliseconds using getIds - " + (stopTimer - startTimer));

        Date date2 = new Date();
        long startTimer1 = date2.getTime();

        Set<String> result = getStrings(shortener, ids);

        Date date3 = new Date();
        long stopTimer1 = date3.getTime();

        System.out.println("Time in milliseconds using getStrings - " + (stopTimer1 - startTimer1));

        if (!result.equals(strings)) {
            System.out.println("Тест не пройден.");
        } else {
            System.out.println("Тест пройден.");
        }
        
    }
}
