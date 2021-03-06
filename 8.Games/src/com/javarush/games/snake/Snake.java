package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.List;
import java.util.ArrayList;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive=true;
    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        if(this.direction==Direction.LEFT&&snakeParts.get(0).x==snakeParts.get(1).x) {return;}
        if(this.direction==Direction.RIGHT&&snakeParts.get(0).x==snakeParts.get(1).x) {return;}
        if(this.direction==Direction.DOWN&&snakeParts.get(0).y==snakeParts.get(1).y) {return;}
        if(this.direction==Direction.UP&&snakeParts.get(0).y==snakeParts.get(1).y) {return;}


        if(this.direction==Direction.RIGHT&&direction!=Direction.LEFT) {this.direction=direction;}
        if(this.direction==Direction.LEFT&&direction!=Direction.RIGHT) {this.direction=direction;}
        if(this.direction==Direction.UP&&direction!=Direction.DOWN) {this.direction=direction;}
        if(this.direction==Direction.DOWN&&direction!=Direction.UP) {this.direction=direction;}
    }

    public Snake(int x, int y) {
        GameObject first = new GameObject(x, y);
        GameObject second = new GameObject(x + 1, y);
        GameObject third = new GameObject(x + 2, y);

        snakeParts.add(first);
        snakeParts.add(second);
        snakeParts.add(third);
    }

    public int getLength(){
        return snakeParts.size();
    }

    public void move(Apple apple){
        GameObject head = createNewHead();

        if (checkCollision(head)) {isAlive=false; return;}

        if (head.y==apple.y&&head.x==apple.x) {
            apple.isAlive=false;}

        if (head.x<0||head.x>SnakeGame.WIDTH-1) {isAlive=false; return;}
            else if (head.y<0||head.y>SnakeGame.HEIGHT-1) {isAlive=false; return;}
                else if (apple.isAlive==false) {snakeParts.add(0, head); return;}
                    else {snakeParts.add(0, head); removeTail();}
    }

    public GameObject createNewHead(){
        GameObject head=null;
        switch (direction){
            case UP: head = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y-1);
                break;
            case RIGHT: head = new GameObject(snakeParts.get(0).x+1, snakeParts.get(0).y);
                break;
            case DOWN: head = new GameObject(snakeParts.get(0).x, snakeParts.get(0).y+1);
                break;
            case LEFT: head = new GameObject(snakeParts.get(0).x-1, snakeParts.get(0).y);
            break;
        }
        return head;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision (GameObject gameObject) {
        boolean check=false;
        for (int i = 0; i < snakeParts.size(); i++) {
            if (gameObject.x == snakeParts.get(i).x & gameObject.y == snakeParts.get(i).y) {
                check= true; break;
            }
        }
        return check;
    }

    public void draw(Game game) {
        Color color = Color.BLACK;
        for (int i = 0; i < snakeParts.size(); i++) {
            if (!isAlive) {color=Color.RED;};
            if (i == 0) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, color, 75);
            } else {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, color, 75);
            }
        }
    }
}
