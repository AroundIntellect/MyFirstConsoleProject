import java.util.Scanner;

public class CheckAllAnswer {
    static Scanner in = new Scanner(System.in);
    static String UserAnswer;
    static int goodCarma = 0;
    static int badCarma = 0;

    static void UserAnswer() {
        UserAnswer = in.nextLine();
    }
    static void WrongAnswer() {
        System.out.println("Пожалуйста, отвечайте цифрами, которые указаны перед вариантами ответа");
    }

    public static void CheckAnswer() {
        UserAnswer();

        switch (UserAnswer) {
            case "1" -> goodCarma++;
            case "2" -> badCarma++;
            default -> {
                WrongAnswer();
                CheckAnswer();
            }
        }
    }

    public static void CheckMorningWakeup() {
        UserAnswer();

        switch (UserAnswer) {
            case "1" -> {
                goodCarma++;
                Game.MorningBeeGood();
            }
            case "2" -> {
                badCarma++;
                Game.MorningBeeGood();
            }
            case "3" -> {
                badCarma += 2;
                Game.MorningBeeBad();
            }
            default -> {
                WrongAnswer();
                CheckMorningWakeup();
            }
        }
    }
    public static void CheckMorningEating() {
        UserAnswer();

        switch (UserAnswer) {
            case "1" -> {
                goodCarma += 2;
                Game.Dinner();
            }
            case "2" ->{
                badCarma += 2;
                Game.CheckHomeWork();
            }
            default -> {
                WrongAnswer();
                CheckMorningEating();
            }
        }
    }
    public static void CheckWhatWithHomeWork() {
        UserAnswer();

        if (UserAnswer.equals("1")) {
            goodCarma++;
            Game.MomSay("Хорошо, сейчас я проверю твою домашнюю работу");
            System.out.println();
            Game.CheckHomeWork();
        } else if (UserAnswer.equals("2")) {
            badCarma += 2;
            Game.MomSay(Game.secondName + ", не надо мне врать, я знаю что и по каким предметам тебе задали! Я вчера созванивалась с Наташей, мамой Павлика из твоей группы!");
            System.out.println();
            Game.CheckHomeWork();
        } else {
            WrongAnswer();
            CheckWhatWithHomeWork();
        }
    }
}
