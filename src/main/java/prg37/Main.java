package prg37;

/**
 * `compareTo` для `Student`.
 *    1. Требования: `Comparable<Student>`; без `Comparator` здесь.
 *    2. Теория: контракт `compareTo`, порядок сортировки, согласованность с `equals`.
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("A", "C");
        Student student2 = new Student("A", "B");
        System.out.println(student1.compareTo(student2));
    }
}
