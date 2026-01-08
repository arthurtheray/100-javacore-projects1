package prg61;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * 61. Сколько дней до ДР
 * Суть: на вход LocalDate дня рождения; на выход — количество дней до следующего ДР.
 * Ограничения: LocalDate, Period; не использовать Date/Calendar.
 * Теория: java.time, сравнение дат, перенос года.
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            LocalDate birthday = askForBirthDay();
            if (birthday.isAfter(LocalDate.now())) {
                System.out.println("Вы еще не родились");
                continue;
            }
            System.out.println("\n");
            System.out.printf("""
                            До дня рождения:
                            %s дней.
                            """,
                    getRemainingUnits(birthday, ChronoUnit.DAYS));
        }
    }

    private static long getRemainingUnits(LocalDate birthday, ChronoUnit chronoUnit) {
        if (birthday.withYear(LocalDate.now().getYear()).isBefore(LocalDate.now())) {
            return LocalDate.now().until(birthday.withYear(LocalDate.now().getYear() + 1), chronoUnit);
        } else {
            return LocalDate.now().until(birthday.withYear(LocalDate.now().getYear()), chronoUnit);
        }
    }

    private static LocalDate askForBirthDay() {
        Scanner scanner = new Scanner(System.in);
        LocalDate userinput = null;
        int year;
        int month;
        int day;
        while (true) {
            while (true) {
                try {
                    System.out.println("Введите год рождения:");
                    year = Integer.parseInt(scanner.nextLine());
                    System.out.println("Введите номер месяца рождения (1-12):");
                    month = Math.clamp(Integer.parseInt(scanner.nextLine()), 1, 12);
                    System.out.println("Введите день рождения: ");
                    day = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.printf("Ошибка: %s. Попробуйте снова", e.getMessage());
                    scanner.nextLine();
                    continue;
                }
                System.out.printf("""
                        Вы ввели:
                            год - %s
                            месяц - %s
                            день - %s
                        Если все верно нажмите enter, для повтора отправьте r
                        """, year, month, day);
                String s = scanner.nextLine();
                if (!s.equals("r")) {
                    break;
                }
            }

            try {
                userinput = LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Ошибка. Некорректная дата " + e.getMessage());
                continue;
            }
            break;
        }
        return userinput;
    }
}
