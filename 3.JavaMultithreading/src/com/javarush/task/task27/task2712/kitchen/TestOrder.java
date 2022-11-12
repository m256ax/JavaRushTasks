package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order{
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        this.dishes =  new ArrayList<>();
        Dish[] array = Dish.values();
        for (int i = 0; i < Dish.values().length; i++){
            Dish d = array[(int) (Math.random()*Dish.values().length)];
        dishes.add(d);
        }
    }

}
