package prg46;


import java.util.Scanner;

/**
 * **Map: счётчик слов.
 * * Требования: `getOrDefault` или `merge`; без стримов.
 * * Теория: `Map` API, `putIfAbsent/merge`, неизменяемые ключи.
 */
public class Main {
    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor();
        while (true) {
            String userInput = askForText();
            assert userInput != null;
            if (userInput.trim().equalsIgnoreCase("!отчёт")) {
                System.out.println(textProcessor.report());
                continue;
            }
            if (userInput.trim().equalsIgnoreCase("!выход")) {
                break;
            }
            int newWords = textProcessor.add(userInput);
            System.out.printf("Добавлено %d новых слов\n", newWords);
            System.out.printf("Всего слов: %s\n", textProcessor.getWordsCount());
        }
    }

    private static String askForText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст или команду (доступные команды: !отчёт; !выход):");
        return scanner.nextLine();
    }
}
