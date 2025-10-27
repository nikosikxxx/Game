package ru.innovationcampus.vsu25.nikitina_v_v.game;

import java.util.Scanner;

public class BigMonster extends Monster {
    private final String image = "\uD83D\uDC79";
    private final Scanner sc = new Scanner(System.in);

    public String getImage() {
        return image;
    }

    BigMonster(int sizeBoard) {
        super(sizeBoard);
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            return simpleTaskMonster();
        } else {
            return complexTaskMonster(difficultGame);
        }
    }

    private boolean complexTaskMonster(int difficultGame) {
        int x = r.nextInt(25 * difficultGame);
        int y = r.nextInt(25);
        int z = r.nextInt(100);
        int q = r.nextInt(2 * difficultGame);
        int w = r.nextInt(6);
        int trueAnswer2 = x * y + z;
        int trueAnswer1 = q * w;
        int strong = r.nextInt(3);

        if (strong == 1 || strong == 2) {
            System.out.println("Реши пример: " + x + " * " + y + " + " + z + " = ?");
            int Answer2 = sc.nextInt();

            if (trueAnswer2 == Answer2) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        } else {
            System.out.println("О нет! Похоже у монстра есть щит!");
            System.out.println("Чтобы его сломать, найдите площадь щита. Первая сторона равна " + q + ", а вторая равна " + w);

            int Answer1 = sc.nextInt();
            if (trueAnswer1 != Answer1) {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }

            System.out.println("Молодец, а теперь разберись с монстром");
            System.out.println("Реши пример: " + x + " * " + y + " + " + z + " = ?");

            int Answer2 = sc.nextInt();
            if (trueAnswer2 == Answer2) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        }
    }

    public boolean simpleTaskMonster() {
        return super.taskMonster(0);
    }
}