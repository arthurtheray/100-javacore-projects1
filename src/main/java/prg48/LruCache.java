package prg48;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @param <K> key
 * @param <V> value
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return capacity < size();
    }

    public LruCache(int capacity) {
        super(Math.max(16, (int)Math.ceil(capacity / 0.75f) + 1), 0.75F, true);
        this.capacity = capacity;
    }
}
