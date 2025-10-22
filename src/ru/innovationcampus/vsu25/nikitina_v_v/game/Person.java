package ru.innovationcampus.vsu25.nikitina_v_v.game;

import java.util.Random;

public class Person {
    private int x, y;
    private String image = "\uD83E\uDDD9\u200D";
    private int live = 3;
    Random r = new Random();

    public int getLive() {
        return live;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return image;
    }


    Person(int sizeBoard) {
        y = sizeBoard;
        int n = r.nextInt(sizeBoard);
        x = n == 0 ? 1 : n;
    }
    void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    void minusLive() {
        live -=1;
    }

    public boolean moveCorrect(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }
}