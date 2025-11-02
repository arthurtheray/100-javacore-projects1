package prg34;


/**
 * Билдер пользователя с необязательными настройками. Для получения пользователя с текущими настройками, необходимо
 * использовать getUser().
 */
public interface UserBuilderInterface {
    /**
     * Добавить номер телефона
     */
    UserBuilderInterface phone(String phoneNumber);

    /**
     * Добавить адрес
     */
    UserBuilderInterface address(String address);

    /**
     * Добавить имя
     */
    UserBuilderInterface name(String name);

    /**
     * Добавить фамилию
     */
    UserBuilderInterface surname(String name);

    /**
     * Добавить дату рождения
     */
    UserBuilderInterface birthday(String birthday);

    /**
     * Сбросить настройки пользователя. Все настроенные ранее поля будут обнулены
     */
    void reset();

    /**
     * Получить пользователя с текущими настройками
     */
    UserInterface getUser();
}
