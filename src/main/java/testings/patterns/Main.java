package testings.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\+[0-5]\\s+.*)|(!список)", Pattern.CASE_INSENSITIVE);
        System.out.println(isValidCommand("!Список"));
    }

    private static boolean isValidCommand(String command) {
        Pattern pattern = Pattern.compile("(\\+[0-5]\\s+.*)|(!список)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(command);
        return matcher.find();
    }
}
