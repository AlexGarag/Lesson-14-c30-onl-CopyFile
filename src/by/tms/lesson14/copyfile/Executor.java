package by.tms.lesson14.copyfile;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Executor {
    public static void main(String[] args) {

        String fileBeingCopied = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\file.txt";
        boolean isApproved = false;
        Scanner scanner = new Scanner(System.in);

        // аналог    ConsoleEmployee.suggestCopying(fileBeingCopied) см. ExecutorStatic
        System.out.print("Вы хотите произвести копирование файла \"" + fileBeingCopied + "\"? Д/Н (Y/N) ");
        char letter = scanner.nextLine().toLowerCase().charAt(0);

        // аналог    ConsoleEmployee.acceptFileName() см. ExecutorStatic
        System.out.print("Введите имя файла-копии: ");
        String nameFile = scanner.next();

        scanner.close();

        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader fileReader = new FileReader(fileBeingCopied);
            FileWriter fileWriter = new FileWriter(nameFile)) {
            while (fileReader.ready()) {
                stringBuilder.append((char)fileReader.read());
            }
            fileWriter.write(stringBuilder.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // проверить через хэш-функцию
        boolean isCopyingSuccessful = false;
        if (isCopyingSuccessful) System.out.println("Результат копироания: успешно");
        else  System.out.println("Результат копирования: не удачно");

    }
}
