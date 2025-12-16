package prg52;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 52. Multi-catch парсинг чисел и дат
 * Суть: на вход строка вида YYYY-MM-DD;number; на выход — суммарная «оценка» (например, день года + число).
 * Ограничения: использовать catch (NumberFormatException | DateTimeParseException); не ловить общий Exception.
 * Теория: многоцелевой catch, порядок catch, специфичные vs общие исключения, java.time.
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println(Optional.ofNullable(getDayOfWeekByInputString(getInputString())).orElseThrow());
            } catch (Exception e) {
                System.out.println("Повторите попытку.");
            }
        }
    }

    private static DayOfWeek getDayOfWeekByInputString(String inputString) {
        String[] tokens = inputString.split(";");
        if (tokens.length != 2) {
            throw new IllegalArgumentException(
                    "Неверный формат строки: " + inputString + "\n" + "ошибочное число токенов");
        }
        DayOfWeek dayOfWeek = null;
        try {
            dayOfWeek = LocalDate.parse(tokens[0]).plusDays(Long.parseLong(tokens[1])).getDayOfWeek();
        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("выброшено исключение " + e.getClass());
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return dayOfWeek;
    }

    /**
     * Запрашивает у пользователя входные данные: дату и количество дней.
     * @return возвращает строку
     */
    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        StringJoiner stringJoiner = new StringJoiner(";");
        System.out.println("Введите дату в формате YYYY-MM-DD:");
        stringJoiner.add(scanner.nextLine());
        System.out.println("Введите количество дней для расчета дня недели:");
        stringJoiner.add(scanner.nextLine());
        return stringJoiner.toString();
    }
}
