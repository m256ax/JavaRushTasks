package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword,  "home", "same", "jhvok", "fulmp", "derl", "hrrplm", "darrj", "om");

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */

    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> list = new ArrayList<>();
        int yL=crossword.length;
        int xL=crossword[0].length;
        for (String word:words) {
            int wordLength = word.length()-1;

            char first = word.charAt(0);
            char last = word.charAt(word.length()-1);

            String temp=null;

            for(int y=0; y<yL;y++) {
                for (int x=0; x<xL;x++) {
                    if (crossword[y][x] == first) {
                        if (y + wordLength < yL) {
                            if (crossword[y + wordLength][x] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int Y=y; Y<=(y + wordLength);Y++) {
                                    sB = sB.append((char) crossword[Y][x]);
                                }
                                    if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint(x, (y + wordLength));
                                    list.add(find);
                                    }
                            }
                        }
                        if(y-wordLength>=0) {
                            if (crossword[y - wordLength][x] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int Y=y; Y>=y-wordLength;Y--) {
                                    sB = sB.append((char)crossword[Y][x]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint(x,(y - wordLength));
                                    list.add(find);
                                }
                            }
                        }
                        if (x + wordLength < xL) {
                            if (crossword[y][x+ wordLength] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int X=x; X<=x+wordLength;X++) {
                                    sB = sB.append((char)crossword[y][X]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint((x + wordLength), y);
                                    list.add(find);
                                }
                            }
                        }
                        if(x-wordLength>=0) {
                            if (crossword[y][x- wordLength] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int X=x; X>=x-wordLength;X--) {
                                    sB = sB.append((char)crossword[y][X]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint(x- wordLength,y);
                                    list.add(find);
                                }
                            }
                        }
                        if (y + wordLength < yL&&x+wordLength<xL) {
                            if (crossword[y + wordLength][x+ wordLength] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int z=0; z<=wordLength;z++) {
                                        sB = sB.append((char) crossword[y+z][x+z]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint((x+ wordLength), (y + wordLength));
                                    list.add(find);
                                }
                            }
                        }
                        if (y - wordLength >=0&&x-wordLength>=0) {
                            if (crossword[y - wordLength][x- wordLength] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int z=0; z<=wordLength;z++) {
                                    sB = sB.append((char) crossword[y-z][x-z]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint((x - wordLength), (y - wordLength));
                                    list.add(find);
                                }
                            }
                        }
                        if (y + wordLength < yL&&x-wordLength>=0) {
                            if (crossword[y + wordLength][x- wordLength] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int z=0; z<=wordLength;z++) {
                                    sB = sB.append((char) crossword[y+z][x-z]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint((x - wordLength), (y + wordLength));
                                    list.add(find);
                                }
                            }
                        }
                        if (y - wordLength >=0&&x+wordLength<xL) {
                            if (crossword[y - wordLength][x+ wordLength] == last) {
                                StringBuilder sB = new StringBuilder();
                                for(int z=0; z<=wordLength;z++) {
                                    sB = sB.append((char) crossword[y-z][x+z]);
                                }
                                if ((temp=sB.toString()).equals(word)) {
                                    Word find = new Word(temp);
                                    find.setStartPoint(x,y);
                                    find.setEndPoint((x + wordLength), (y - wordLength));
                                    list.add(find);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}