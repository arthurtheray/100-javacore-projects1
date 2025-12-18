package prg54;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * 54. Подсчёт строк/слов/символов в файле
 * Суть: на вход путь к текстовому файлу; на выход — количество строк, слов, символов.
 * Ограничения: Files.readAllLines или поток строк Files.lines; без Scanner.
 * Теория: кодировки (Charset), работа со списками и стримами строк.
 */
public class Main {
    public static void main(String[] args) {
        String pathToFile = "E:\\Obsidian\\Мои знания\\Auto snake.md";
        printTextFileInformationV2(pathToFile);
        printTextFileInformation(pathToFile);
    }

    private static void printTextFileInformation(String pathToFile) {
        long start = System.nanoTime();
        Path path = Paths.get(pathToFile);
        if (!Files.exists(path)) {
            System.out.println("Файл " + path + " не доступен");
            return;
        }
        AtomicInteger linesCount = new AtomicInteger();
        AtomicInteger wordsCount = new AtomicInteger();
        AtomicInteger charsCount = new AtomicInteger();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
            lines.forEach(string -> {
                linesCount.addAndGet(1);
                wordsCount.addAndGet(string.split("\\s+").length);
                charsCount.addAndGet(string.length());
            });
        } catch (IOException e) {
            System.out.println("Не удалось открыть файл");
            return;
        }
        System.out.printf("В заданном файле (%s) %d строк, %d слов и %d символов\n",
                path, linesCount.get(), wordsCount.get(), charsCount.get());
        System.out.println("Подсчет занял: " + (System.nanoTime() - start));
    }

    private static void printTextFileInformationV2(String pathToFile) {
        long start = System.nanoTime();
        Path path = Paths.get(pathToFile);
        if (!Files.exists(path)) {
            System.out.println("Файл " + path + " не доступен");
            return;
        }
        int linesCount = 0;
        int wordsCount = 0;
        int charsCount = 0;
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
            List<String> linesList = lines.toList();
            for (String line : linesList) {
                charsCount += line.length();
                wordsCount += line.trim().split("\\s+").length;
                linesCount++;
            }
        } catch (IOException e) {
            System.out.println("Не удалось открыть файл");
            return;
        }
        System.out.printf("В заданном файле (%s) %d строк, %d слов и %d символов\n", path, linesCount, wordsCount, charsCount);
        System.out.println("Подсчет занял: " + (System.nanoTime() - start));
    }
}
