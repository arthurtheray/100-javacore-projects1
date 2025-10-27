package prg27;

/**
 * `equals`/`hashCode` для `Person`.
 *    1. Требования: контракты соблюдены; не использовать IDE-генерацию.
 *    2. Теория: контракт `equals/hashCode`, симметрия/транзитивность, `Objects.equals/hash`.
 */
public class Main {
    public static void main(String[] args) {

        Person person = new Person(12, "Юра");
        Male male = new Male(12, "Юра");
        System.out.println(person.equals(male));

    }


}
