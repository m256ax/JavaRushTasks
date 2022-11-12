package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance;
    private final AdvertisementStorage aD = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {}

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null)
            instance = new StatisticAdvertisementManager();
        return instance;
    }

    public Map<String, Integer> activeVideoSet(){
        List<Advertisement> baseList = new ArrayList(aD.list());
        Map<String, Integer> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement a: baseList) {
            if (a.isActive()) {
                result.put(a.getName(), a.getHits());
            }
        }
        return result;
    }

    public Map<String, Integer> archiveVideoSet(){
        List<Advertisement> baseList = new ArrayList(aD.list());
        Map<String, Integer> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Advertisement a: baseList) {
            if (!a.isActive()) {
                result.put(a.getName(),null);
            }
        }
        return result;
    }

}
