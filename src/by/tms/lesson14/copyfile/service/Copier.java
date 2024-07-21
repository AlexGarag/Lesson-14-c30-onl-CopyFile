package by.tms.lesson14.copyfile.service;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copier {
    public static boolean copyFile(File srcFile, File destFile) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(srcFile.getAbsoluteFile());
             FileWriter fileWriter = new FileWriter(destFile.getAbsoluteFile())) {
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
