package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit(){
        Map<String, Long> baseMap = StatisticManager.getInstance().profitForDay();
        ArrayList<String> list = new ArrayList(baseMap.keySet());
        Collections.sort(list);
        for (String date: list) {
            double money = 1.0 * baseMap.get(date)/100;
        ConsoleHelper.writeMessage(String.format("%s - %.2f", date ,money));
        }
    }

    public void printCookWorkloading() { // другая реализация в образце
        TreeMap<String, TreeMap<String, Integer>> baseMap = StatisticManager.getInstance().workTimeForCook();
        String startDate = "";
        for (Map.Entry entry : baseMap.entrySet()) {
            if (!startDate.equals(entry.getKey())) {
                ConsoleHelper.writeMessage((String) entry.getKey());
                startDate = (String) entry.getKey();
            }
            TreeMap<String, Integer> innerMap = (TreeMap<String, Integer>) entry.getValue();
            for (Map.Entry innerEntry : innerMap.entrySet()) {
                ConsoleHelper.writeMessage(String.format("%s - %d min", innerEntry.getKey(), innerEntry.getValue()));
            }
        }
    }

    public void printActiveVideoSet(){
        Map<String, Integer> baseMap = StatisticAdvertisementManager.getInstance().activeVideoSet();
        ArrayList<String> list = new ArrayList<>(baseMap.keySet());
        for (String videoName: list) {
            ConsoleHelper.writeMessage(String.format("%s - %d", videoName, baseMap.get(videoName)));
        }
    }

    public void printArchivedVideoSet(){
        Map<String, Integer> baseMap = StatisticAdvertisementManager.getInstance().archiveVideoSet();
        ArrayList<String> list = new ArrayList<>(baseMap.keySet());
        for (String videoName: list) {
            ConsoleHelper.writeMessage(videoName);
        }

    }
}
