package prg41;

/**
 * Generics: `Box<T>`.
 *    1. Требования: обобщённый класс; без сырых типов.
 *    2. Теория: обобщения (generics), стирание типов (erasure), инвариантность.
 */
public class Main {
    public static void main(String[] args) {
        Box<String> stringsBox = new Box<>();
        stringsBox.add("Маша");
        stringsBox.add("Артур");
        stringsBox.add("Триша");
        stringsBox.add("Шкура");
        stringsBox.add("Том");
        System.out.println(stringsBox.getAll());

        System.out.println("Извлекаем кошек\n" + stringsBox.get(3));

        System.out.println("\n");

        System.out.println("в коробочке остались: \n" + stringsBox.getAll());
    }
}
