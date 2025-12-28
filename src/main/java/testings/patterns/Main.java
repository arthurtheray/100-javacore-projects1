package testings.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\+[0-5]\\s+.*)|(!список)", Pattern.CASE_INSENSITIVE);
        System.out.println(isValidCommand("!Список"));
        String str = "\"qw\"e\",qweqwe,\"qwe\",\"qw\",\"qwee\"";
        Pattern pattern1 = Pattern.compile("\"?.*\"?");
        //  "qw"e",qweqwe,"qwe","qw","qwee"
        //  "qw""e",qweqwe,"qwe"",""","qwee"
        //

        //  иду до первой запятой,
        //  проверяю начинается ли подстрока до запятой с кавычки, если нет - continue
        //          если да -  проверяю есть ли кавычка перед запятой, если есть - continue
//          если нет - иду до следующей запятой
        //
    }

    private static boolean isValidCommand(String command) {
        Pattern pattern = Pattern.compile("(\\+[0-5]\\s+.*)|(!список)", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher(command);
        return matcher.find();
    }
}
