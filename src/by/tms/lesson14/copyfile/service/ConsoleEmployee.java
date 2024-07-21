package by.tms.lesson14.copyfile.service;

import java.util.Scanner;

public class ConsoleEmployee {

    public static boolean suggestCoping(String nameFile) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Вы хотите произвести копирование файла \"" + nameFile + "\"? Д/Н (Y/N) ");
        char letter = scanner.nextLine().toLowerCase().charAt(0);
        if (letter == 'y' || letter == 'д') return true;
        else return false;
    }

    public static String enterStringData(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        return scanner.next();
    }

    public static void cancelActionExit(String text) {
        System.out.println(text);
        System.exit(0);
    }

}