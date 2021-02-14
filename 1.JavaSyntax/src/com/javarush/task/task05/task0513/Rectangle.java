package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top;
    int left;
    int width;
    int height;
    
    public void initialize (int top, int left, int wigth, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    
    public void initialize (int top, int left) {
        this.top = top;
        this.left = left;
    }
    
    public void initialize(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
    }
    

    public void initialize (Rectangle rectangle) {
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public static void main(String[] args) {

    }
}
