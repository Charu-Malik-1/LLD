package low_level_design.cache.policies;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class LRUPolicy<K, V> implements PolicyInterface<K, V> {
    private final Map<K, LocalDateTime> timeTable;

    public LRUPolicy() {
        timeTable = new HashMap<>();
    }

    private void updateTimeTable(K key) {
        if (timeTable.get(key) != null) {
            timeTable.remove(key);
        }
        timeTable.put(key, LocalDateTime.now());
    }

    @Override
    public boolean updatePolicyTable(K key) {
        updateTimeTable(key);
        return true;
    }

    /**
     * evict the last entry from low_level_design.cache
     */
    @Override
    public boolean evictFromCache(Map<K, V> cacheData) {

        K lastKey = null;
        for (Map.Entry<K, LocalDateTime> entry : timeTable.entrySet()) {
            lastKey = entry.getKey();
        }

        cacheData.remove(lastKey);
        timeTable.remove(lastKey);
        System.out.println("evicte value from low_level_design.cache");
        return true;
    }
}
