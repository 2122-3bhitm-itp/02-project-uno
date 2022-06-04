package at.htl.quiz.util;

import java.util.Scanner;

public class CommandLineUtil {
    public static String getLine() {
        var sc = new Scanner(System.in);
        return sc.next();
    }
}
