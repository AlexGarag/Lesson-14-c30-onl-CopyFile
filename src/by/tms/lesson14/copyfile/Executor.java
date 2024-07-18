package by.tms.lesson14.copyfile;

import java.io.IOException;
import java.util.Scanner;

import static by.tms.lesson14.copyfile.service.Copier.copyFile;

public class Executor {
    public static void main(String[] args) {
        final String failed = "Результат копирования: не удачно";
        final String success = "Результат копирования: успешно";
//        final String regexFileNamePath = "^([a-zA-Z]:)?(\\[a-zA-Z0-9._-]+)+\\?$";

//        String originalFileNameWithPass = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\file.txt";
        String originalFileNameWithPass = "Lesson-14-c30-onl-CopyFile\\*.txt";
        String originalFileName = originalFileNameWithPass.substring((originalFileNameWithPass.lastIndexOf('\\')) + 1);
        boolean isApproved = false;
        Scanner scanner = new Scanner(System.in);

// аналог    ConsoleEmployee.suggestCopying(originalFileName) см. ExecutorStatic
        System.out.print("Вы хотите произвести копирование файла \"" + originalFileName + "\"? Д/Н (Y/N) ");
        char letter = scanner.nextLine().toLowerCase().charAt(0);
        if (letter == 'y' || letter == 'д') {
// аналог    ConsoleEmployee.acceptFileName() см. ExecutorStatic
            System.out.print("Введите имя файла-копии: ");
            String copyFileName = scanner.next();
//            boolean isMatch = false;
//            do {
//                Pattern pattern = Pattern.compile(regexFileNamePath);
//                Matcher matcher = pattern.matcher(copyFileName);
//                isMatch = matcher.find();
//            } while(isMatch);


            // копирование файла с проверкой
            try {
                if (copyFile(originalFileName, copyFileName)) System.out.println(success);
                else System.out.println(failed);
            } catch (IOException e) {
                System.out.println(failed); //throw new RuntimeException(e);
            }
        }
        scanner.close();
    }
}
