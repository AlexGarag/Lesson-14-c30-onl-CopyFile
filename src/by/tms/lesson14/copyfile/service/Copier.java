package by.tms.lesson14.copyfile.service;

import java.io.*;
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

    public static boolean copyBufferFile(File srcFile, File destFile) {
        BufferedInputStream fis = null;
        BufferedOutputStream fos = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(srcFile));
            fos = new BufferedOutputStream(new FileOutputStream(destFile));
        } catch (FileNotFoundException e) {
            return false;
        }
        byte[] buffer = new byte[16384];
        int bytes = 0;
        try {
            bytes = fis.read(buffer);
        } catch (IOException e) {
            return false;
        }
        while (bytes != -1) {
            try {
                fos.write(buffer, 0, bytes);
            } catch (IOException e) {
                return false;
            }
            try {
                bytes = fis.read(buffer);
            } catch (IOException e) {
                return false;
            }
        }
        try {
            fos.flush();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
