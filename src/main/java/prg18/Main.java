package prg18;

/**
 * Строковый палиндром.
 *    1. Требования: `StringBuilder.reverse` запрещён; сравнение по индексам.
 *    2. Теория: `String` vs `StringBuilder`, нормализация регистра, `charAt`, `Character`.
 */
public class Main {
    public static void main(String[] args) {
        String text = "А роза упала на лапу Азора";
        System.out.println(isPalindrome(text, true) ? "палиндром" : "не палиндром");
        System.out.println(isPalindrome(text, false) ? "палиндром" : "не палиндром");
    }

    /**
     * @param text проверяемый текст
     * @param spacesIncluded true - если требуется учитывать пробелы при проверке, false - если пробелы не учитываются
     * @return true - если текст является палиндром, false - если не является
     */
    private static boolean isPalindrome(String text, boolean spacesIncluded) {

        String normalizedText;
        normalizedText = spacesIncluded ? text.toLowerCase().trim() : text.toLowerCase().replaceAll(" ", "");

        int start = 0;
        int end = normalizedText.length() - 1;
        while (start < end) {
            if (normalizedText.charAt(start) != normalizedText.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
