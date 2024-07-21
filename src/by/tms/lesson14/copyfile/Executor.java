package by.tms.lesson14.copyfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import static by.tms.lesson14.copyfile.service.ConsoleEmployee.*;
import static by.tms.lesson14.copyfile.service.Copier.copyFile;
import static by.tms.lesson14.copyfile.service.GetterHash.getHash;

public class Executor {
    public static void main(String[] args) {
        final String canceled = "Копирование отменено";
        final String fileNotFound = " - файл-источник не найден!";
        final String toEnterNameCopy = "Введите имя файла-копии: ";
        final String toEnterPathCopy = "Введите путь к файлу-копии: ";
        final String failed = "Результат копирования: не удачно";
        final String hashFailed = "Результат копирования: файлы различаются";
        final String success = "Результат копирования: успешно";
//        final String regexFileNamePath = "^([a-zA-Z]:)?(\\[a-zA-Z0-9._-]+)+\\?$";

        String originalFileName = "file.txt";
        String originalPassFile = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\files";

        File originalFile = new File(originalPassFile, originalFileName);

        if (!suggestCoping(originalFile.getName())) {
            cancelActionExit(canceled);
        }
        if (!originalFile.exists()) {
            cancelActionExit(canceled + fileNotFound);
        }

        File copyFile = new File(enterStringData(toEnterPathCopy), enterStringData(toEnterNameCopy));
//todo проверить имя файла и путь по регулярке
//
// копирование файла с проверкой успешности
//
        if (copyFile(originalFile, copyFile)) {
// и с итоговой проверкой "сходимости" файлов через хэш-функцию
            try {
                if (getHash(originalFile).equals(getHash(copyFile))) System.out.println(success);
                else System.out.println(hashFailed);
            } catch (IOException | NoSuchAlgorithmException e) {
                System.out.println(failed);
            }
        } else {
            System.out.println(failed);
        }
//
// использую для копирования методы класса Files
//
        File copyFile2 = new File("C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\files", "file.txt2");
        Path originalPath = Paths.get(originalFile.getPath());
        Path copyPath2 = Paths.get(copyFile2.getPath());
        if (copyFile(originalPath, copyPath2)) {
// и с итоговой проверкой "сходимости" файлов через хэш-функцию
            try {
                if (getHash(originalFile).equals(getHash(copyFile2))) System.out.println(success);
                else System.out.println(hashFailed);
            } catch (IOException | NoSuchAlgorithmException e) {
                System.out.println(failed);
            }
        } else {
            System.out.println(failed);
        }
    }
}
