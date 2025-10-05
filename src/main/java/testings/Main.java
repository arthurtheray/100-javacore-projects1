package testings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String str = "1+2+3";
        System.out.println(Arrays.toString(str.split("\\+")));
    }
}
