package by.tms.lesson14.copyfile.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Copier {
    public static boolean copyFile(File srcFile, File destFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(srcFile);
             FileWriter fileWriter = new FileWriter(destFile)) {
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean copyFile(Path srcPath, Path destPath) {
        try {
            Files.copy(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
