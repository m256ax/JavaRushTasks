package com.javarush.games.moonlander;

public class Rocket extends GameObject {
    private double speedY = 0;
    private double speedX = 0;
    private double boost = 0.05;

    public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed) {
        if (isUpPressed) {
            this.speedY -= boost;
        } else {
            this.speedY += boost;
        }
        this.y += speedY;

        if (isLeftPressed) {
            this.speedX -= boost;
            this.x += speedX;
        } else if (isRightPressed) {
            this.speedX += boost;
            this.x += speedX;
        }
    }
}
