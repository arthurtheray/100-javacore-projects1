package prg39;

/**
 * Моя реализация упрощенного аналога List из JDK
 * @param <T> тип объектов для добавления в список
 */
public interface MyList<T> {
    /**
     * Добавить элемент в конец списка
     * @param element добавляемый элемент
     */
    void add(T element);

    /**
     * Добавит элемент в список по указанному индексу. При этом все существующие элементы справа (при наличии)
     * сдвигаются вправо
     * @param element  добавляемый элемент
     * @param index индекс в который встанет элемент. Нумерация начинается с 0
     * @throws IndexOutOfBoundsException если запрашиваемый индекс меньше 0 или больше size
     */
    void add(T element, int index) throws IndexOutOfBoundsException;

    /**
     * Получить объект по запрашиваемому индексу
     * @param index необходимый индекс
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс если запрашиваемый индекс меньше 0 или больше size
     */
    T get(int index) throws IndexOutOfBoundsException;

    /**
     * Возвращает первый элемент списка
     * @return первый элемент списка
     */
    T getFirst() throws IllegalStateException;

    /**
     * Возвращает последний элемент списка
     * @return последний элемент списка
     */
    T getLast() throws IllegalStateException;

    /**
     * Возвращает длину списка (количество элементов в списке)
     * @return длину списка. Возвращает 0 если список пустой
     */
    int size();
}
