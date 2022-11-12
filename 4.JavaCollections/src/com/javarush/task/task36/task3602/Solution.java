package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 6 лекция

Описание класса:
1. Реализует интерфейс List;
2. Является приватным статическим классом внутри популярного утилитного класса;
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.


Requirements:
1. Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
2. Метод getExpectedClass должен вернуть правильный тип.
3. Метод main должен вызывать метод getExpectedClass.
4. Метод main должен вывести полученный класс на экран.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] cS = Collections.class.getDeclaredClasses();
        for (Class<?> c : cS) {
            if (List.class.isAssignableFrom(c.getSuperclass())) {
                int mod = c.getModifiers();
                if (Modifier.isPrivate(mod) && Modifier.isStatic(mod)) {
                        try {
                            Method m = c.getDeclaredMethod("get", int.class);
                            m.setAccessible(true);
                            Constructor<?> constructor = c.getDeclaredConstructor();
                            constructor.setAccessible(true);
                            m.invoke(constructor.newInstance(), 0);
                        } catch (InvocationTargetException e) {
                            if (e.getCause().toString().contains("IndexOutOfBoundsException")) {
                                return c;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        return null;
    }
}
