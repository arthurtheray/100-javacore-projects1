package prg51;

import java.util.Scanner;

/**
 * 51. Валидация ввода и исключения
 * Суть: функция парсинга настроек из строк: на вход строковые параметры; на выход — объект настроек или сообщение об ошибке.
 * Ограничения: бросать осмысленные IllegalArgumentException/NumberFormatException; ловить в main и печатать на System.err;
 * без сторонних валидационных библиотек.
 * Теория: дизайн исключений, пред- и постусловия, обработка и сообщение об ошибке.
 */
public class Main{
    public static void main(String[] args) {
        while (true) {
            String userInput = getUserInput();
            try {
                Settings settings = new Settings(userInput);
                System.out.println(settings);
            } catch (WrongSettingsException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметры:");
        return scanner.nextLine().trim().toLowerCase();
    }
}
