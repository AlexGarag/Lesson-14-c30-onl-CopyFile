package by.tms.lesson14.copyfile.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verifier {
    public static boolean verifyText(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
