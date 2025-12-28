package prg55;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringJoiner;

/**
 * Сериализует список пользователей и сохраняет в CSV файл по заданному пути
 */
public abstract class PersonsCsvGenerator {
    public static void make(Path destinationPath, List<Person> persons) throws IOException {

        if (destinationPath == null) {
            throw new NullPointerException();
        }
        List<String> lines = persons.stream().map(v -> {

            StringJoiner stringJoiner = new StringJoiner(",");
            stringJoiner.add(PersonsCsvGenerator.normalize(v.name()))
                    .add(PersonsCsvGenerator.normalize(v.surname()))
                    .add(PersonsCsvGenerator.normalize(v.fathername()))
                    .add(v.birthday().toString());
            return stringJoiner.toString();
        }).toList();
        Files.write(destinationPath, lines, StandardCharsets.UTF_8);
        System.out.println("Файл " + destinationPath + " создан");
    }

    private static String normalize(String s) {
        String s1 = s.replaceAll("\"", "\"\"");
        return s1.contains(",") || s1.contains("\"") || s1.contains("\n")
                ? "\"" + s1 + "\""
                : s1;

    }
}
