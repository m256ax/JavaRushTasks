package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start = new Date().getTime();
        for (String s : strings) {
           ids.add(shortener.getId(s));
        }
        long stop = new Date().getTime();
        return stop - start;
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long start = new Date().getTime();
        for (Long id : ids) {
            shortener.getString(id);
        }
        long stop = new Date().getTime();
        return stop - start;
    }

    @Test
    public void testHashMapStorage() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        HashBiMapStorageStrategy biMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener1 = new Shortener(hashMapStorageStrategy);
        Shortener shortener2 = new Shortener(biMapStorageStrategy);
        Set<String> origStrings = new HashSet<>();
        Set<Long> originLongs = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long test1 = getTimeToGetIds(shortener1, origStrings, originLongs);
        long test2 = getTimeToGetIds(shortener2, origStrings, originLongs);;

        Assert.assertTrue(test1 > test2);

        long test3 = getTimeToGetStrings(shortener1, originLongs, origStrings);
        long test4 = getTimeToGetStrings(shortener2, originLongs, origStrings);

        Assert.assertEquals(test3, test4, 30);

    }

}
