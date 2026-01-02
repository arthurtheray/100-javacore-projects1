package testings.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(new FileOutputStream(new File("data\\output.dat"))))) {
            printWriter.println("hello");
            printWriter.println("hello world");
        } catch (Exception e) {
            System.out.println("ошибка вывода\n" + e.getMessage());
        }
    }
}
