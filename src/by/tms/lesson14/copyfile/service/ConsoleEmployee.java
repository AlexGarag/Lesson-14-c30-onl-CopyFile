package by.tms.lesson14.copyfile.service;

import java.util.Scanner;

public class ConsoleEmployee {

    public static boolean suggestCopyng(String nameFile) {
//        boolean isApproved = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Вы хотите произвести копирование файла \"" + nameFile + "\"? Д/Н (Y/N) ");
        char letter = scanner.nextLine().toLowerCase().charAt(0);
        if (letter == 'y' || letter == 'д') return true;
        else return false;
//        scanner.close();
//        return isApproved;
    }

    public static String acceptFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла-копии: ");
        String nameFile = scanner.next();
//        scanner.close();
        return nameFile;
    }

    public static void cancelActionExit() {
        final String canceled = "Копирование отменено";
        System.out.println(canceled);
        System.exit(0);
    }

}