package by.tms.lesson14.copyfile;

import by.tms.lesson14.copyfile.service.GetterHash;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {
        final String failed = "Результат копирования: не удачно";
        final String success = "Результат копирования: успешно";

        String original = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\file.txt";
        boolean isApproved = false;
        Scanner scanner = new Scanner(System.in);

        // аналог    ConsoleEmployee.suggestCopying(original) см. ExecutorStatic
        System.out.print("Вы хотите произвести копирование файла \"" + original + "\"? Д/Н (Y/N) ");
        char letter = scanner.nextLine().toLowerCase().charAt(0);
//todo отработать отказ от копирования
        // аналог    ConsoleEmployee.acceptFileName() см. ExecutorStatic
        System.out.print("Введите имя файла-копии: ");
        String copy = scanner.next();
        // todo проверить имя и путь через регулярку
        scanner.close();

        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(original);
             FileWriter fileWriter = new FileWriter(copy)) {
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// проверка правильности копирования через хэш-функцию
        try {
            if (GetterHash.getHash(original).equals(GetterHash.getHash(copy))) System.out.println(success);
            else System.out.println(failed);
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
