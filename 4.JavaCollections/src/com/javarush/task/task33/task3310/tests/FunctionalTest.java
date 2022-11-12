package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;

import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String string1 = "qwerty";
        String string2 = "12345";
        String string3 = "qwerty";

        long id1 = shortener.getId(string1);
        long id2 = shortener.getId(string2);
        long id3 = shortener.getId(string3);

        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);

        Assert.assertEquals(id1, id3);

        String res1 = shortener.getString(id1);
        String res2 = shortener.getString(id2);
        String res3 = shortener.getString(id3);

        Assert.assertEquals(string1, res1);
        Assert.assertEquals(string2, res2);
        Assert.assertEquals(string3, res3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy hash = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hash);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy hash = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(hash);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy hash = new FileStorageStrategy();
        Shortener shortener = new Shortener(hash);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy hash = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hash);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy hash = new DualHashBidiMapStorageStrategy();
//        Shortener shortener = new Shortener(hash);
//        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy hash = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hash);
        testStorage(shortener);
    }

}
