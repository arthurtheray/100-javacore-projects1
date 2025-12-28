package prg56;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 56. Парсинг CSV
 * Суть: на вход CSV-файл; на выход — список объектов.
 * Ограничения: допустимо упрощение: кавычки вокруг полей, запятые внутри кавычек; без библиотек.
 * Теория: регулярные выражения/ручной разбор, обработка границ и кавычек.
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(CsvReader.read(Files.newInputStream(Paths.get("persons.csv"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
