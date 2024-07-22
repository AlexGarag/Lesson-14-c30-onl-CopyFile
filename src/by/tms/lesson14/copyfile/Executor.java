package by.tms.lesson14.copyfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import static by.tms.lesson14.copyfile.service.ConsoleEmployee.*;
import static by.tms.lesson14.copyfile.service.Copier.copyBufferFile;
import static by.tms.lesson14.copyfile.service.Copier.copyFile;
import static by.tms.lesson14.copyfile.service.GetterHash.getHash;
import static by.tms.lesson14.copyfile.service.Verifier.verifyText;

public class Executor {
    public static void main(String[] args) {
        final String canceled = "Копирование отменено";
        final String fileNotFound = " - файл-источник не найден!";
        final String invalidNamePathFile = " - некорректные имя-путь файла-копии!";
        final String toEnterNameCopy = "Введите имя файла-копии: ";
        final String toEnterPathCopy = "Введите путь к файлу-копии: ";
        final String failed = "Результат копирования: не удачно";
        final String hashFailed = "Результат копирования: файлы различаются";
        final String success = "Результат копирования: успешно";
        final String regexFileNamePath = "([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?";

//        String srcFileName = "file.txt";
//        String srcPassFile = "C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\files";
        String srcFileName = "VID_20180616_115025.mp4";
        String srcPassFile = "F:\\Фотографии\\Присяга Ильи";

        File srcFile = new File(srcPassFile, srcFileName);

        if (!suggestCoping(srcFile.getName())) cancelActionExit(canceled);
        if (!srcFile.exists()) cancelActionExit(canceled + fileNotFound);

        File destFile = new File(enterStringData(toEnterPathCopy), enterStringData(toEnterNameCopy));
        if (!verifyText(destFile.getPath(), regexFileNamePath)) cancelActionExit(canceled + invalidNamePathFile);

        if (srcFile.length() < 16384) {     // если копируемый файл не большой
//
// копирование файла с проверкой успешности
//
            if (copyFile(srcFile, destFile)) {
// и с итоговой проверкой "сходимости" файлов через хэш-функцию
                try {
                    if (getHash(srcFile).equals(getHash(destFile))) System.out.println(success);
                    else System.out.println(hashFailed);
                } catch (IOException | NoSuchAlgorithmException e) {
                    System.out.println(failed);
                }
            } else {
                System.out.println(failed);
            }
//
// использую для копирования методы класса Files (сделал для апробирования)
//
            File copyFile2 = new File("C:\\Users\\123\\IdeaProjects\\Lesson-14-c30-onl-CopyFile\\files", "file.txt2");
            Path originalPath = Paths.get(srcFile.getPath());
            Path copyPath2 = Paths.get(copyFile2.getPath());
            if (!copyFile(originalPath, copyPath2)) System.out.println(failed);
        } else { // если файл копирования большой - используем буфферизацию
            if (!copyBufferFile(srcFile, destFile)) System.out.println(failed);
            else  System.out.println(success);
        }
    }
}
