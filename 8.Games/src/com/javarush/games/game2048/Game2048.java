package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped=false;
    private int score;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = null;
        gameField = new int[SIDE][SIDE];
        for (int j = 0; j < SIDE; j++) {
            for (int i = 0; i < SIDE; i++) {
                gameField[j][i] = 0;
            }
        }
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void win(){
        isGameStopped=true;
        showMessageDialog(Color.RED, "You are win!", Color.ALICEBLUE, 56);
    }

    private void gameOver(){
        isGameStopped=true;
        showMessageDialog(Color.RED, "Game over!", Color.ALICEBLUE, 56);
    }

    private void createNewNumber() {
        if (getMaxTileValue()==2048) {
            win();
        }

        int x = getRandomNumber(SIDE);
        int y = getRandomNumber(SIDE);
        if (gameField[x][y] == 0) {
            int r = getRandomNumber(10);
            if (r == 9) gameField[y][x] = 4;
            else gameField[y][x] = 2;
        } else createNewNumber();
    }

    private Color getColorByValue(int value) {
        Color c = Color.AZURE;
        switch (value) {
            case 0:
                c = Color.AZURE;
                break;
            case 2:
                c = Color.BLUE;
                break;
            case 4:
                c = Color.ROSYBROWN;
                break;
            case 8:
                c = Color.HONEYDEW;
                break;
            case 16:
                c = Color.NAVAJOWHITE;
                break;
            case 32:
                c = Color.DARKCYAN;
                break;
            case 64:
                c = Color.MAGENTA;
                break;
            case 128:
                c = Color.CORAL;
                break;
            case 256:
                c = Color.PEACHPUFF;
                break;
            case 512:
                c = Color.INDIGO;
                break;
            case 1024:
                c = Color.CHOCOLATE;
                break;
            case 2048:
                c = Color.AQUAMARINE;
                break;
        }
        return c;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        if (value == 0) setCellValueEx(x, y, getColorByValue(value), "");
        else setCellValueEx(x, y, getColorByValue(value), Integer.toString(value));
    }

    private boolean compressRow(int[] row) {
        boolean bool = false;

        for (int j = 0; j < row.length; j++) {
            for (int i = 1; i < row.length; i++) {
                if (row[i] != 0 && row[i - 1] == 0) {
                    bool = true;
                    int temp = row[i - 1];
                    row[i - 1] = row[i];
                    row[i] = temp;
                }
            }
        }
    return bool;
    }

    private boolean mergeRow(int[] row){
        boolean bool = false;

            for (int i = 1; i < row.length; i++) {
                if (row[i] != 0 && row[i - 1] == row[i]) {
                    bool = true;
                    row[i - 1] += row[i];
                    score+=row[i-1];
                    setScore(score);
                    row[i] = 0;
                }
            }
        return bool;
    }

    @Override
    public void onKeyPress(Key key) {
            if (key==Key.SPACE) {
                score=0;
                setScore(0);
                isGameStopped = false;
                createGame();
                drawScene();
                return;
            }
        if (!isGameStopped) {
            if (canUserMove()) {
            switch (key) {
                case UP:
                    moveUp();
                    drawScene();
                    break;
                case DOWN:
                    moveDown();
                    drawScene();
                    break;
                case LEFT:
                    moveLeft();
                    drawScene();
                    break;
                case RIGHT:
                    moveRight();
                    drawScene();
                    break;
            }
        }
        } else gameOver();
    }

    private void moveLeft(){
        boolean change = false;
        for (int i = 0; i < SIDE; i++) {
            if( compressRow( gameField[i] )) change = true;
            if( mergeRow( gameField[i] )) change = true;
            if( compressRow( gameField[i] )) change = true;
        }
        if( change ) createNewNumber();
    }
    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise(){
        int [][] neo = new int[SIDE][SIDE];

        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                neo[y][x]=gameField[y][x];
            }
        }

        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                gameField[y][x]=neo[(SIDE-1)-x][y];
                }
            }
        }

    private int getMaxTileValue(){
        int max = 0;
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                if (max<gameField[y][x]) max = gameField[y][x];
            }
        }
        return max;
    }

    private boolean canUserMove(){
        boolean can = false;
        for (int x = 0; x < gameField.length; x++) {
            for (int y = 0; y < gameField.length; y++) {
                if(gameField[y][x]==0) can=true;
            }
        }

            for (int x = 0; x < gameField.length; x++) {
                for (int y = 1; y < gameField.length; y++) {
                    if (gameField[y][x] != 0 && gameField[y - 1][x] == gameField[y][x]) {
                        can = true;
                    }
                }
            }

            for (int y = 0; y < gameField.length; y++) {
                for (int x = 1; x < gameField.length; x++) {
                    if (gameField[y][x] != 0 && gameField[y][x - 1] == gameField[y][x]) {
                        can = true;
                    }
                }
            }
        return can;
    }
}
