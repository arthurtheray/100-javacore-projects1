package prg55;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

/**
 * 55. Запись CSV
 * Суть: на вход список объектов (например, Person); на выход — корректный CSV (с кавычками/экранированием).
 * Ограничения: без сторонних CSV-библиотек; корректно экранировать запятые и кавычки.
 * Теория: формат CSV, экранирование полей, StringJoiner, Files.write.
 */
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Arthur", "Bulatov", "Maratovi,ch", LocalDate.parse("1990-06-29"));
        Person person2 = new Person("Maria", "Tr", "Vyacheslavna", LocalDate.parse("1989-10-22"));
        List<Person> personList = List.of(person1, person2);
        Path csvPath = Paths.get("persons.csv");
        try {
            PersonsCsvGenerator.make(csvPath, personList);
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл\n");
            e.printStackTrace();
        }
    }
}

