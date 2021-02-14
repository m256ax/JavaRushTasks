package com.javarush.task.task14.task1408;


public class BelarusianHen extends Hen {
    
    int getCountOfEggsPerMonth(){
        return 44;
    }
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}