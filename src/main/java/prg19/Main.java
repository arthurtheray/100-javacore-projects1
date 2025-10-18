package prg19;

/**
 * **Подсчёт слов. Количество слов в строке.
 *    1. Требования: разбивка по пробелам регуляркой `\\s+`; без ручного парсинга.
 *    2. Теория: регулярные выражения, `String.split`, экранирование.
 */
public class Main {
    public static void main(String[] args) {
        String text1 = " Cовершенно случайный текст, который я ввел чтобы протестировать работу программы))";
        String text2 = "";
        String text3 = "текст";
        String text4 = " ";
        System.out.printf("В строке \"%s\" %d слов\n", text1, countSpaces(text1));
        System.out.printf("В строке \"%s\" %s слов\n", text2, countSpaces(text2));
        System.out.printf("В строке \"%s\" %s слов\n", text3, countSpaces(text3));
        System.out.printf("В строке \"%s\" %s слов\n", text4, countSpaces(text4));
    }

    private static int countSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int count = 0;
        for (String word : words) {
            if (!word.isBlank()) {
                 count++;
            }
        }
        return count;
    }
}
