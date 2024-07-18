package by.tms.lesson14.copyfile;

import by.tms.lesson14.copyfile.service.ConsoleEmployee;

public class ExecutorStatic {
    public static void main(String[] args) {
        String fileBeingCopied = "textFrom.txt";
        String copyFileName;
        if (ConsoleEmployee.suggestCopying(fileBeingCopied)) copyFileName = ConsoleEmployee.acceptFileName();
        else copyFileName = "-";

        System.out.println(copyFileName);
    }
}
