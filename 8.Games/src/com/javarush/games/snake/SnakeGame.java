package com.javarush.games.snake;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private final static int GOAL=28;
    private int score;
    
    public void initialize() {
    setScreenSize(WIDTH, WIDTH); 
    createGame();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                snake.setDirection(Direction.LEFT); break;
            case RIGHT: snake.setDirection(Direction.RIGHT); break;
            case UP: snake.setDirection(Direction.UP); break;
            case DOWN: snake.setDirection(Direction.DOWN); break;
            case SPACE: if (isGameStopped) {createGame(); break;} break;
        }
    }

    private void createNewApple(){
        boolean bool=true;
        while(true) {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
            if(!snake.checkCollision(apple)) return;
        }
    }

    private void createGame(){
        score=0;
        turnDelay=300;
        setTurnTimer(turnDelay);
        snake= new Snake(WIDTH/2, HEIGHT/2);
        createNewApple();
        isGameStopped=false;
        setScore(score);
        drawScene();
    }

    private void gameOver() {
         stopTurnTimer();
         showMessageDialog(Color.BLACK, "GAME OVER", Color.ROYALBLUE, 75);
         isGameStopped = true;
    }

    private void win() {
        stopTurnTimer();
        showMessageDialog(Color.BLACK, "YOU WIN", Color.ROYALBLUE, 75);
        isGameStopped = true;
    }

    public void onTurn(int step) {
        snake.move(apple);
        if(!apple.isAlive) {
            setScore(score+=5);
            setTurnTimer(turnDelay-=10);
        }
        if (apple.isAlive == false) {createNewApple();}
        if(!snake.isAlive) {gameOver();}
        if(snake.getLength()>GOAL) {win();}
        drawScene();
    }

    private void drawScene(){
    for (int x = 0; x < WIDTH; x++) {
        for (int y = 0; y < HEIGHT; y++) {
            setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }
}