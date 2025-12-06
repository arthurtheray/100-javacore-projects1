package prg48;

import java.util.Iterator;
import java.util.Map;

/**
 * *`LinkedHashMap` как LRU.
 * * Требования: `removeEldestEntry`; без внешних библиотек.
 * * Теория: порядок итерации вставки/доступа, переопределение поведения.
 */
public class Main {

    public static void main(String[] args) {
        LruCache<String, Integer> lruCache = new LruCache<>(3);
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        testCache(lruCache);
        lruCache.put("D", 4);
        testCache(lruCache);
    }

    private static void testCache(LruCache<String, Integer> lruCache) {
        Iterator<Map.Entry<String, Integer>> iterator = lruCache.entrySet().iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            builder
                    .append(iterator.next())
                    .append("\n\n");
        }
        System.out.println(builder);
    }


}
