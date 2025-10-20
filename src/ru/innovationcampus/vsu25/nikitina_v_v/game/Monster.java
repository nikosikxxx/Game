package ru.innovationcampus.vsu25.nikitina_v_v.game;

import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83E\uDDDF\u200D";
    private int x,y;
    Random r = new Random();

    public String getImage() {
        return image;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }


    Monster(int sizeBoard) {
        this.x = r.nextInt(sizeBoard - 1);
        this.y = r.nextInt(sizeBoard);
    }
    public boolean conflictPerson(int perX, int perY){
        return perY - 1 == this.y && perX - 1 == this.x;
    }
    public boolean taskMonster(int difficultGame) {
        int x = r.nextInt(100);
        int y = r.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
        int trueAnswer = x + y;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner sc = new Scanner(System.in);
        int Answer = sc.nextInt();
        if (trueAnswer == Answer) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        }
        System.out.println("Ты проиграл эту битву!");
        return false;
    }
}