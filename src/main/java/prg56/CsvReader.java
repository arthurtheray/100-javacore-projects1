package prg56;

import prg55.Person;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private static final char DELIMITER = ',';
    private static final char QUOTES = '"';
    private static final int TOKENS_SIZE = 4;

    public static List<Person> parsePersons(InputStream inputStream) throws IOException {
        List<Person> fieldsOfPersons = new ArrayList<>();
        boolean quoted = false;
        int wrongLinesCount = 0;
        try (inputStream;
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> tokens = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    char thisChar = line.charAt(i);
                    switch (thisChar) {
                        case QUOTES -> {
                            if (i == line.length() - 1) {
                                tokens.add(sb.toString());
                                sb.setLength(0);
                            } else if (quoted && line.charAt(i + 1) == QUOTES) {
                                sb.append(thisChar);
                                i++;
                            } else if (quoted && line.charAt(i + 1) == DELIMITER) {
                                tokens.add(sb.toString());
                                sb.setLength(0);
                                quoted = false;
                                i++;
                            } else {
                                quoted = true;
                            }
                        }
                        case DELIMITER -> {
                            if (!quoted) {
                                tokens.add(sb.toString());
                                sb.setLength(0);
                            } else {
                                sb.append(thisChar);
                            }
                        }
                        default -> {
                            sb.append(thisChar);
                            if (i == line.length() - 1) {
                                tokens.add(sb.toString());
                                sb.setLength(0);
                            }
                        }
                    }
                }
                if (tokens.size() > TOKENS_SIZE) {
                    throw new IOException("Ошибка при парсинге строки " + line +
                            "\n Неверное число полей");
                }
                try {
                    fieldsOfPersons.add(
                            new Person(tokens.get(0), tokens.get(1), tokens.get(2), LocalDate.parse(tokens.get(3))));
                } catch (Exception e) {
                    System.out.println("Ошибка: Некорректный формат строки " + line + "\n");
                    wrongLinesCount++;
                }
            }
            System.out.printf(
                    """
                            Парсинг завершен.
                            Успешно спаршено %d объектов.
                           Не удалось спарсить: %d строк
                           
                           """, fieldsOfPersons.size(), wrongLinesCount
                    );
        }
        return fieldsOfPersons;
    }
}