package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomInvocationHandler implements InvocationHandler {

    Object target;

    public CustomInvocationHandler(SomeInterfaceWithMethods methods) {
       this.target = methods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
//        чтобы не было задвоения результат вызова метода присваиваем переменной
        Object result = method.invoke(target, args);
        System.out.println(method.getName() + " out");
        return  result;
    }
}
