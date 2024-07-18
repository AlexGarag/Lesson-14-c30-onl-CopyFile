package by.tms.lesson14.copyfile;

import by.tms.lesson14.copyfile.service.GetterHash;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static by.tms.lesson14.copyfile.service.Copier.copyFile;
//import static java.lang.System.exit;

public class Executor {
    public static void main(String[] args) {
        final String failed = "Результат копирования: не удачно";
        final String hashFailed = "Результат копирования: файлы различаются";
        final String success = "Результат копирования: успешно";
//        final String regexFileNamePath = "^([a-zA-Z]:)?(\\[a-zA-Z0-9._-]+)+\\?$";

        String originalFileNameWithPass = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\files\\file.txt";
        String copyFileName = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\files\\text2.txt";
//        String originalFileNameWithPass = "Lesson-14-c30-onl-CopyFile\\*.txt";
        String originalFileName = originalFileNameWithPass.substring((originalFileNameWithPass.lastIndexOf('\\')) + 1);
//        boolean isApproved = false;
//        Scanner scanner = new Scanner(System.in);

// аналог    ConsoleEmployee.suggestCopying(originalFileName) см. ExecutorStatic
//        System.out.print("Вы хотите произвести копирование файла \"" + originalFileName + "\"? Д/Н (Y/N) ");
//        char letter = scanner.nextLine().toLowerCase().charAt(0);
        if (/*letter == 'y' || letter == 'д'*/true) {
// аналог    ConsoleEmployee.acceptFileName() см. ExecutorStatic
//            System.out.print("Введите имя файла-копии: ");
//            String copyFileName = /*scanner.next()*/"text2.txt";

// копирование файла
            if (copyFile(originalFileName, copyFileName)) {
// с итоговой проверкой "сходимости" файлов
                try {
                    if (GetterHash.getHash(originalFileName).equals(GetterHash.getHash(copyFileName))) System.out.println(success);
                    else System.out.println(hashFailed);
                } catch (IOException | NoSuchAlgorithmException e) {
                    System.out.println(failed);
                }
            } else {
                System.out.println(failed);
            }
        }
    }
}
