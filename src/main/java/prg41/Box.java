package prg41;

import java.util.ArrayList;
import java.util.List;

/**
 * Коробочка для хранения объектов. Объекты сохраняются в порядке их добавления. Методом get() можно извлечь объекты из хранилища,
 * при этом извлекаются последние добавленные объекты. После извлечения объекты из хранилища исчезают
 * @param <T> Любой объект
 */
public class Box<T> {
    private final List<T> elements = new ArrayList<>();

    /**
     * Добавить элемент на "верх" хранилища
     * @param elem добавляемый элемент
     */
    public void add(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("null в коробочку добавлять нельзя");
        }

        this.elements.add(elem);
    }

    /**
     * Извлекает элементы с верху содержимого коробочки
     * @param count количество доставаемых элементов
     * @return список (List<T>) из count последних элементов
     */
    public List<T> get(int count) {
        if (count <= 0) {
            throw new RuntimeException("count must be higher then 0");
        }

        if (count > elements.size()) {
            throw new IllegalArgumentException("Requested quantity " + count +
                    " exceeds available quantity: " + elements.size());
        }

        List<T> requestedElems = new ArrayList<>();

        while (count != 0) {
            requestedElems.add(elements.remove(elements.size() - count));
            count--;
        }

        return requestedElems;
    }

    public List<T> getAll() {
        return elements;
    }
}
