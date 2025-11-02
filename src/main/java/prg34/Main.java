package prg34;

/**
 * Шаблон Builder (ручной). `UserBuilder` с необязательными полями.
 *    1. Требования: вложенный статический `Builder`; без Lombok.
 *    2. Теория: паттерн Builder, fluent-API, неизменяемые объекты.
 */
public class Main {
    public static void main(String[] args) {
        UserBuilderInterface userBuilder = new UserBuilder();
        UserInterface arthur = userBuilder
                .name("Arthur")
                .phone("+79961060712")
                .getUser();
        UserInterface maria = userBuilder
                .name("Maria")
                .surname("Troshina")
                .birthday("26.10.1989")
                .getUser();
        System.out.println(arthur);
        System.out.println(maria);
    }
}
