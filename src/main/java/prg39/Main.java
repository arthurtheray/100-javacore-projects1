package prg39;

import java.util.List;

/**
 * Вложенные/внутренние классы. Свой `LinkedList`.
 *    1. Требования: внутренний `Node`; без коллекций JDK.
 *    2. Теория: nested/inner classes, доступ к полям внешнего класса.
 */
public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Мама");
        list.add("мыла");
        list.add("раму");
        list.add("Моя", 0);
        System.out.println(list);
    }
}
