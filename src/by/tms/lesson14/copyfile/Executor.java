package by.tms.lesson14.copyfile;

import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {

        String fileBeingCopied = "textFrom.txt";
        boolean isApproved = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Вы хотите произвести копирование файла \"" + fileBeingCopied + "\"? Д/Н (Y/N) ");
        char letter = scanner.nextLine().toLowerCase().charAt(0);
//        if (letter == 'y' || letter == 'д') isApproved = true;
        System.out.print("Введите имя файла-копии: ");
        String nameFile = scanner.next();
        scanner.close();

        System.out.println(nameFile);

    }
}
