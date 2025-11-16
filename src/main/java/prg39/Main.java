package prg39;

/**
 * Вложенные/внутренние классы. Свой `LinkedList`.
 *    1. Требования: внутренний `Node`; без коллекций JDK.
 *    2. Теория: nested/inner classes, доступ к полям внешнего класса.
 *   Обновлено 13.11.2025: Внес правки по результат code-review
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Мама");
        list.add("мыла");
        list.add("раму");
        list.add("Моя", 0);
        list.add("грязную", 3);
        list.add("тщательно", list.size());

        System.out.println("итоговый лист:" + list);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println("testing iterator:");
        for (String str:list) {
            System.out.println(str);
        }
    }
}
