package ru.innovationcampus.vsu25.nikitina_v_v.game;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int difficultGame = 0;
        int sizeBoard = 5;
        int step = 0;
        String castle = "\uD83C\uDFF0";
        Person person = new Person(sizeBoard);
        int countMonster = sizeBoard * sizeBoard - sizeBoard - 7;
        Random r = new Random();

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 0; y < sizeBoard; y++) {
            for (int x = 0; x < sizeBoard; x++) {
                board[y][x] = "  ";
            }
        }

        Monster[] monsters = new Monster[countMonster + 1];
        int count = 0;
        Monster test;
        while (count <= countMonster){

            if (r.nextBoolean()) {
                test = new Monster(sizeBoard);
            }else {
                test = new BigMonster(sizeBoard);
            }
            if (board[test.getY()][test.getX()].equals("  ")){
                board[test.getY()][test.getX()] = test.getImage();
                monsters[count] = test;
                count++;
            }

        }


        int castleX = r.nextInt(sizeBoard);
        int castleY = 0;
        board[castleY][castleX] = castle;

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer){
            case "ДА":
                while (true) {
                    System.out.println("Выбери сложность игры(от 1 до 5)");
                    difficultGame = sc.nextInt();
                    if (difficultGame >= 1 && difficultGame <= 5) {
                        System.out.println("Выбранная сложность:\t" + difficultGame);
                        break;
                    } else {
                        System.out.println("Неверная сложность");
                    }
                }
                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();

                    outputBoard(board, person.getLive());



                    System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;"
                            + "\nКоординаты персонажа - (x: " + person.getX() + ", y: " + person.getY() + "))");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    if (person.moveCorrect(x, y)) {
                        String next = board[y - 1][x - 1];
                        if (next.equals("  ")) {
                            board[person.getY() - 1][person.getX() - 1] = "  ";
                            person.move(x, y);
                            step++;
                            System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                    "\nХод номер: " + step);
                        } else if (next.equals(castle)) {
                            System.out.println("Вы прошли игру!");
                            break;
                        } else {
                            for (Monster monster : monsters) {
                                if (monster.conflictPerson(x, y)) {
                                    if (monster.taskMonster(difficultGame)) {
                                        board[person.getY() - 1][person.getX() - 1] = "  ";
                                        person.move(x, y);
                                    } else {
                                        person.minusLive();
                                    }
                                    break;
                                }}
                        }
                    } else {
                        System.out.println("Неккоректный ход");
                    }
                    if (person.getLive() <= 0) {
                        System.out.println("Игра окончена! Закончились жизни.");
                        break;
                    }
                }
                break;


            case "НЕТ":
                System.out.println("Жаль, приходи еще!");
                break;
            default:
                System.out.println("Данные введены некорректно");
        }
    }

    static void outputBoard(String[][] board, int lives) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] row : board) {
            System.out.println(wall);
            for (String col : row) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);
        System.out.println("Количество жизней:\t" + lives + "\n");
    }

}