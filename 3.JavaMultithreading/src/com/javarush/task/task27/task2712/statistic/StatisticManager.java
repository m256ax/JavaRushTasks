package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){}

    public static StatisticManager getInstance() {
        if(instance == null)
            instance = new StatisticManager();
        return instance;
    }

    public Map<String, Long> profitForDay(){
        List<EventDataRow> rows = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Map<String, Long> profit = new HashMap<>();
        long total = 0l;
        for (EventDataRow o: rows) {
            VideoSelectedEventDataRow dataRow =  (VideoSelectedEventDataRow) o;
            String date = dateFormat.format(dataRow.getDate());
            total+=dataRow.getAmount();
            if (profit.containsKey(date)) {
                profit.put(date, (profit.get(date) + dataRow.getAmount()));
            }
            else profit.put(date, dataRow.getAmount());
        }
        profit.put("Total", total);

        return profit;
        }

    public TreeMap workTimeForCook(){
        TreeMap<String, TreeMap<String,Integer>> timeCooks = new TreeMap<>(Collections.reverseOrder());
        SimpleDateFormat dF = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Object o: statisticStorage.getStorage().get(EventType.COOKED_ORDER)
             ) {

            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) o;

            String cookName = cookedOrderEventDataRow.getCookName();
            int cookingTimeSeconds = cookedOrderEventDataRow.getTime();
            String currentDate = dF.format(cookedOrderEventDataRow.getDate());

           if(timeCooks.containsKey(currentDate)){
               TreeMap<String, Integer> integerTreeMap = timeCooks.get(currentDate);
               for (Map.Entry entry: integerTreeMap.entrySet()
                    ) {
                   String name = (String) entry.getKey();
                   Integer cookingTime = (Integer) entry.getValue();
                        if(name.equals(cookName)){
                        integerTreeMap.replace(cookName, cookingTime + cookingTimeSeconds/60);
                        timeCooks.replace(currentDate, integerTreeMap);
                        } else if (cookingTimeSeconds!=0){
                        integerTreeMap.put(cookName, cookingTimeSeconds/60);
                        timeCooks.put(currentDate, integerTreeMap);
                     }
               }
           } else {
               TreeMap<String, Integer> innerTM = new TreeMap<>();
               innerTM.put(cookName, cookingTimeSeconds/60);
               timeCooks.put(currentDate, innerTM);
           }
     }
        return timeCooks;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType: EventType.values()
                 ) {
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        private Map<EventType, List<EventDataRow>> getStorage(){
            return storage;
        }
    }
}
