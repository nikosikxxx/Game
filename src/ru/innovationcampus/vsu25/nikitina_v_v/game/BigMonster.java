package ru.innovationcampus.vsu25.nikitina_v_v.game;

import java.util.Scanner;

public class BigMonster extends Monster{
    private String image = "\uD83D\uDC79";
    public String getImage() {
        return image;
    }
    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }
    @Override
    public boolean taskMonster(int difficultGame){
        if (difficultGame == 1) {
            return taskMonster();
        } else {
            int x = r.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = r.nextInt(10);
            int z = r.nextInt(100);
            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
            Scanner sc = new Scanner(System.in);
            int Answer = sc.nextInt();
            if (trueAnswer == Answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } System.out.println("Ты проиграл эту битву!");
            return false;
        }
    }
    public boolean taskMonster() {
        return super.taskMonster(0);
    }
}