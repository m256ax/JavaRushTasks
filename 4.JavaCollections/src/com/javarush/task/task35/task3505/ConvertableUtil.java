package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V> Map<K, V> convert(List<? extends Convertable> list) {
        Map<K, V> result = new HashMap();
        for (Convertable e : list
        ) {
            result.put((K) e.getKey(), (V) e);
        }
        return result;
    }
}
