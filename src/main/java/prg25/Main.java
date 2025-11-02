package prg25;

import java.math.BigDecimal;

/**
 * Перегрузка методов. `print(Object)`, `print(int)`, `print(String)`.
 *    1. Требования: показать выбор перегрузки; без вар-аргов.
 *    2. Теория: перегрузка vs переопределение, подбор перегрузки, автоупаковка.
 */
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(13);
        printer.print("Hello");
        printer.print(new BigDecimal("123"));
        printer.print(Integer.valueOf(Integer.MAX_VALUE));
    }
}
