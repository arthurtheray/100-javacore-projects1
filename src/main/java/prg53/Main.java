package prg53;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 53. Копирование файла (try-with-resources)
 * Суть: на вход путь источника и назначения; на выход — скопированный файл и время копирования.
 * Ограничения: Files.newInputStream/newOutputStream + try-with-resources; не использовать FileInputStream/FileOutputStream напрямую и сторонние IO-библиотеки.
 * Теория: AutoCloseable, NIO Files, управление ресурсами.
 */
public class Main {
    public static void main(String[] args) {
        Path from = Paths.get("E:\\java-projects\\100-javacore-projects1\\target\\src\\text.dat");
        Path to = Paths.get("E:\\java-projects\\100-javacore-projects1\\target\\src\\text_copy.dat");
        try {
            copyFile1(from, to);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        copyFile2(from, Paths.get("E:\\java-projects\\100-javacore-projects1\\target\\src\\text_copy2.dat"));
    }

    private static void copyFile2(Path from, Path to) {
        long startNanoTime = System.nanoTime();
        if (Files.exists(from)) {
            try {
                Files.copy(from, to);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Методы выполнился за " + (startNanoTime - System.nanoTime()));
    }

    private static void copyFile1(Path from, Path to) throws IOException {
        long startNanoTime = System.nanoTime();
        if (Files.exists(from)) {
                try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(from));
                     DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(to))) {
                    while (dataInputStream.available() != 0) {
                    dataOutputStream.write(dataInputStream.read());
                    }
                }
            }
            else {
                throw new IOException("Файл отсутствует");
            }
        System.out.println("Методы выполнился за " + (startNanoTime - System.nanoTime()));
    }
}

