package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles=SIDE*SIDE;
    private int score;
    private static final String MINE="\uD83D\uDCA3";
    private static final String FLAG="\uD83D\uDEA9";
    private boolean isGameStopped;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        super.onMouseLeftClick(x, y);
        if (isGameStopped) {restart(); return;}
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        super.onMouseRightClick(x, y);
        markTile(x, y);
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellValue( x,y,"");
            }
        }
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags=countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                 if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors (){
        List<GameObject> list;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine){
                    list = getNeighbors(gameField[y][x]);
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void openTile(int x, int y){
        List<GameObject> list;
        if (gameField[y][x].isOpen) return;
        if (gameField[y][x].isFlag) return;
        if (isGameStopped) return;
        if(gameField[y][x].isMine==true)
        {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        }
        else {
            setCellNumber(x, y, gameField[x][y].countMineNeighbors);
        gameField[y][x].isOpen=true;
        countClosedTiles--;
        setScore(score+=5);
        setCellColor(x, y, Color.GREEN);
        }
        if (gameField[y][x].isMine==false&&gameField[x][y].countMineNeighbors==0) {
            setCellValue(x,y,"");
            list = getNeighbors(gameField[y][x]);
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).isOpen) {
                    openTile(list.get(i).x, list.get(i).y);
                }
            }
        }
        if (countClosedTiles==countMinesOnField&&gameField[y][x].isMine==false) {
            win();
        }
    }

    private void markTile(int x, int y){
        if (isGameStopped) return;
        if (gameField[y][x].isOpen)
        {
            return;
        }
        if (countFlags==0&&gameField[y][x].isFlag==false)
        {
            return;
        }
        if (gameField[y][x].isFlag==false) {
            countFlags=countFlags-1;
            gameField[y][x].isFlag=true;
            setCellValue(x,y,FLAG);
            setCellColor(x,y,Color.YELLOW);
        }
        else {
            countFlags=countFlags+1;
            gameField[y][x].isFlag=false;
            setCellValue(x,y,"");
            setCellColor(x,y,Color.ORANGE);
        }
    }

    private void gameOver(){
        isGameStopped=true;
        showMessageDialog(Color.BLACK, "Game over", Color.AZURE, 75);
    }

    private void win(){
        isGameStopped=true;
        showMessageDialog(Color.BLACK, "You win!", Color.AZURE, 75);
    }

    private void restart(){
        isGameStopped=false;
        countClosedTiles=SIDE*SIDE;
        setScore(score=0);
        countMinesOnField=0;
        createGame();
    }
}
