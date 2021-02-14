package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлон1", dateFormat.parse("JANUARY 1 2013"));
        map.put("Сталлон2", dateFormat.parse("JULY 1 2011"));
        map.put("Сталлон3", dateFormat.parse("AUGUST 1 2014"));
        map.put("Сталлон4", dateFormat.parse("SEPTEMBER 1 2015"));
        map.put("Сталлон5", dateFormat.parse("OCTOBER 1 2016"));
        map.put("Сталлон6", dateFormat.parse("NOVEMBER 1 2017"));
        map.put("Сталлон7", dateFormat.parse("JULY 1 2018"));
        map.put("Сталлон8", dateFormat.parse("APRIL 1 2018"));
        map.put("Сталлон9", dateFormat.parse("JUNE 1 2912"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
    Iterator <Map.Entry<String, Date>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
    Map.Entry<String, Date> pair = iterator.next();
    int month = pair.getValue().getMonth();

    if (month>=5 && month<=7) 
    {
    iterator.remove();
    }
    }
    }

    public static void main(String[] args) {
    }
}
