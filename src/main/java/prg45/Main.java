package prg45;

import prg40.StdIo;

import java.util.HashSet;
import java.util.Set;

/**
 * **Set: уникальные email’ы.**
 * * Требования: `HashSet`; без стримов.
 * * Теория: множества, равенство и хеширование, нормализация строк.
 */
public class Main {
    private static final StdIo stdIo = StdIo.INSTANCE;

    public static void main(String[] args) {
        Set<String> emails = new HashSet<>();
        while (true) {
            try {
                emails.add(askForEmail());
                stdIo.print(emails.toString());
                if (emails.size() > 10) {
                    stdIo.print("Достигнуто максимальное количество email-ов");
                    break;
                }
            } catch (Exception e) {
                stdIo.print("Неверный ввод");
            }
        }
    }

    private static String askForEmail() {
        stdIo.print("Введите e-mail:");
        String nextInput = stdIo.read();
        String normalized = nextInput.toLowerCase().trim();
        if (isValidEmail(normalized)) {
            return normalized;
        }
        else {
            throw new IllegalArgumentException("Некорректный формат e-mail");
        }
    }

    private static boolean isValidEmail(String email) {
        return email.matches("[a-z0-9-_.]+@[a-z0-9-]+.[a-z]+");
    }
}
