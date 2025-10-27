package ru.innovationcampus.vsu25.nikitina_v_v.game;

import java.util.Random;
import java.util.Scanner;

public class Monster {
    private String image = "\uD83E\uDDDF\u200D";
    private int x, y;
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

    //если мне расскажут как сделать вероятность, я сделаю так чтобы при небольшом шансе у монстра был тотем возрождения. Типо его надо победить 2 раза
    public boolean conflictPerson(int perX, int perY) {
        return perY - 1 == this.y && perX - 1 == this.x;
    }

    public boolean taskMonster(int difficultGame) {
        int x = r.nextInt(300);
        int y = r.nextInt(100 * difficultGame);
        int trueAnswer2 = x + y;
        int strong = r.nextInt(3);
        int q = r.nextInt(25 * difficultGame);
        int w = r.nextInt(25);
        int trueAnswer1 = q + w;
        Scanner sc = new Scanner(System.in);
        if (strong == 1 || strong == 2) {
            System.out.println("Реши пример: " + x + " + " + y +" = ?");
            int Answer2 = sc.nextInt();

            if (trueAnswer2 == Answer2) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        } else {
            System.out.println("О нет! Похоже у монстра 2 жизни!");
            System.out.println("Реши пример: " + x + " + " + y +" = ?");

            int Answer2 = sc.nextInt();
            if (trueAnswer2 != Answer2) {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }

            System.out.println("Молодец, а теперь победи его окончательно!");
            System.out.println("Реши пример: " + q + " + " + w +" = ?");

            int Answer1 = sc.nextInt();
            if (trueAnswer1 == Answer1) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        }

        }
    }