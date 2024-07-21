package by.tms.lesson14.copyfile.service;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifier {
    public static boolean verifyNamePathFile(File file, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(file.getPath());
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
