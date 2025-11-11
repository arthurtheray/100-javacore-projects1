package prg40;

/**
 * Enum `DayOfWeek` c логикой.
 *    1. Требования: методы у enum; без `switch` с числами.
 *    2. Теория: `enum` как класс, поля/методы/конструкторы enum.
 */
public class Main {
    static StdIo stdIo = StdIo.INSTANCE;

    public static void main(String[] args) {

        stdIo.print("Введите день недели");

        String in = stdIo.read();

        sayNumberOfDayAndCheckForHoliday(in);
    }

    private static void sayNumberOfDayAndCheckForHoliday(String in) {

        int numberOfWeek;

        try {
            numberOfWeek = DayOfWeek.byRussian(in).getNumber();
        } catch (NullPointerException e) {
            stdIo.print("Такого дня недели нет");
            return;
        }

        stdIo.print(in + " это день недели с порядковым номером " + numberOfWeek
                + (DayOfWeek.byRussian(in).isHoliday() ? "\nКстати это выходной" : ""));
    }
}
