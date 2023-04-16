package org.example;

import org.example.Classes.Abstract.Game;
import org.example.Classes.Answer;
import org.example.Classes.GameType.EngGame;
import org.example.Classes.GameType.NumberGame;
import org.example.Classes.GameType.RuGame;
import org.example.Enum.GameStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Добро пожаловать в игру Быки и Коровы ===");
        System.out.println("Выберите тип игры: ");
        System.out.println("Введите 1 для игры с числами.");
        System.out.println("Введите 2 для игры с русскими словами.");
        System.out.println("Введите 3 для игры с английскими словами.");
        System.out.print("Введите значение: ");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        while (input < 1 || input > 3){
            System.out.print("Введите пожалуйста цифру от 1 до 3: ");
            input = scanner.nextInt();
            scanner.nextLine();
        }
        Game game = null;
        int wordSize = 0;
        int attempts = 0;
        switch (input) {
            case 1:
                game = new NumberGame();
                System.out.print("Введите длину числа: ");
                wordSize = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите максимальное количество попыток: ");
                attempts = scanner.nextInt();
                scanner.nextLine();
                break;
            case 2:
                game = new RuGame();
                System.out.print("Введите длину слова: ");
                wordSize = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.print("Введите максимальное количество попыток: ");
                attempts = scanner.nextInt();
                scanner.nextLine();
                break;
            case 3:
                game = new EngGame();
                System.out.print("Введите длину слова: ");
                wordSize = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Введите максимальное количество попыток: ");
                attempts = scanner.nextInt();
                scanner.nextLine();
                break;
            default:
                System.out.println("Такой игры еще нет.");
        }
        game.start(wordSize, attempts);
        int attemptCount = 1;
        while (game.getGameStatus().equals(GameStatus.START)) {
            System.out.println();
            System.out.println("     Попытка " + attemptCount++);
            System.out.print("Введите значение: ");
            String answer = scanner.nextLine();
            while (answer.length() != game.getWordSize()){
                System.out.println();
                System.out.print("Введите значение длиной " + game.getWordSize() +  " символов(а): ");
                answer = scanner.nextLine();
            }
            if (answer.equals(game.getWord())) {
                game.win();
                System.out.println();
                System.out.println("Победа! Значение, загаданное компьютером: " + game.getWord());
            }
            Answer answerGame = game.inputValue(answer);
            if (game.getAttempts() == 0 && game.getGameStatus() == GameStatus.START) {
                game.lose();
                System.out.println();
                System.out.println("Игра окончена! Попытки закончились.");
            } else if (game.getGameStatus() != GameStatus.WIN
                    && game.getGameStatus() != GameStatus.LOSE) {
                System.out.println();
                System.out.println("Коров: " + answerGame.getCow());
                System.out.println("Быков: " + answerGame.getBull());
            }
        }
        scanner.close();
    }
}