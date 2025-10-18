package prg20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Частота символов. Посчитать частоты.
 *    1. Требования: массив на 256 или `Map<Character,Integer>` — на выбор; без Stream API.
 *    2. Теория: `HashMap` базовые операции, автоупаковка/распаковка, кодировки по верхам.
 */
public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get("E://text.txt");
        Character myChar = 'а';
        System.out.printf("1) в тексте содержится %d символов %s\n", getCharCountFromFile(filePath, myChar), myChar);
        Map<Character, Integer> allCharsCount = getAllCharsCountFromText(filePath);
        System.out.printf("2) в тексте %s %s символов '%s'", filePath.getFileName().toString(),
                allCharsCount.get(myChar), myChar);
    }

    private static Map<Character, Integer> getAllCharsCountFromText(Path filePath) {
        Map<Character, Integer> allCharsCount = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char ch:line.toCharArray()) {
                    if (allCharsCount.containsKey(ch)) {
                        allCharsCount.compute(ch, (k, count) -> count + 1);
                    } else {
                        allCharsCount.put(ch, 1);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return allCharsCount;
    }

    private static int getCharCountFromFile(Path filePath, Character character) {
        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                for (char ch:line.toCharArray()) {
                    if (ch == character) count++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка подсчета символов", e);
        }
        return count;
    }
}
