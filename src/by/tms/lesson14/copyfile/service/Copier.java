package by.tms.lesson14.copyfile.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copier {
    public static boolean copyFile(String srcFile, String destFile) {
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
}
