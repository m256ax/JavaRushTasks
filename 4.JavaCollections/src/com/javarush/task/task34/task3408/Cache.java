package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    //TODO add your code here
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        Object o = cache.get(key);
        if (o == null) {
            V newValue = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, newValue);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here

        try {
            // МАГИЯ РЕФЛЕКСИИ
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            cache.put((K) method.invoke(obj), obj);
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
