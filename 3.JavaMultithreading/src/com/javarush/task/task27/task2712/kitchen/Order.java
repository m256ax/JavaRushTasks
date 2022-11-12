package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
        ConsoleHelper.writeMessage(toString());
    }

    public int getTotalCookingTime(){
        int sum=0;
        for (Dish dish: dishes) {
            sum+=dish.getDuration();
        }
        return sum;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() { // другой вывод в образце
        return "Your order:" +
                " " + dishes +
                " of " + tablet +
                ", cooking time " +
                getTotalCookingTime() +
                "min";
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException{
       this.dishes =  ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }
}
