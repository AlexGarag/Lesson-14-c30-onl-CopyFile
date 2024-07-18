package by.tms.lesson14.copyfile.service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Copier {
    public static boolean copyFile(String srcFile, String destFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader fileReader = new FileReader(srcFile);
             FileWriter fileWriter = new FileWriter(destFile)) {
            while (fileReader.ready()) {
                stringBuilder.append((char) fileReader.read());
            }
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
// проверка правильности копирования через хэш-функцию
        try {
            if (GetterHash.getHash(srcFile).equals(GetterHash.getHash(destFile))) return true;
            else return false;
        } catch (IOException | NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
