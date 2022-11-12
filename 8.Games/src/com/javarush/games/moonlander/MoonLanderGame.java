package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public final static int WIDTH = 64;
    public final static int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;


    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void createGameObjects(){
        this.rocket = new Rocket(WIDTH/2, 0);
        this.landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }

    private void createGame(){
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isUpPressed = false;
        isLeftPressed = false;
        isRightPressed = false;
    }

    private void drawScene(){
        for (int x=0; x<WIDTH; x++) {
            for (int y = 0; y< HEIGHT; y++) {
                setCellColor(x, y, Color.BLACK);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }

    @Override
    public void onTurn(int step) {
     this.rocket.move( isUpPressed,  isLeftPressed,  isRightPressed);
     drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x > WIDTH && y > HEIGHT )
                super.setCellColor(x, y, color);
    }

    @Override
    public void onKeyPress(Key key) {
//        super.onKeyPress(key);
        switch (key) {
            case UP: isUpPressed = true;
            break;
            case LEFT: isLeftPressed = true;
            isRightPressed = false;
            break;
            case RIGHT: isRightPressed = true;
            isLeftPressed = false;
            break;
        }
    }

    @Override
    public void onKeyReleased(Key key) {
//        super.onKeyReleased(key);
        switch (key){
            case UP: isUpPressed = false;
            break;
            case LEFT: isLeftPressed = false;
            break;
            case RIGHT: isRightPressed = false;
            break;
        }
    }
}
