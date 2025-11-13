package low_level_design1.cache.policies;

import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class LFUPolicy<K, V> implements PolicyInterface<K, V> {
    private final Map<K, Integer> freqTable;

    public LFUPolicy() {
        freqTable = new LinkedHashMap<>();
    }

    private void updateFrequencyTable(K key) {
        if (freqTable.get(key) != null) {
            int v = freqTable.get(key);
            freqTable.remove(key);
            v++;
            freqTable.put(key, v);
        } else {
            freqTable.put(key, 1);
        }
    }

    @Override
    public boolean updatePolicyTable(K key) {
        updateFrequencyTable(key);
        return true;
    }

    /**
     * evict the least frequently used value
     */
    @Override
    public boolean evictFromCache(Map<K, V> cacheData) {
        int leastFrequency = Integer.MAX_VALUE;
        K minKey = null;
        for (Map.Entry<K, Integer> entry : freqTable.entrySet()) {
            if (entry.getValue() < leastFrequency) {
                minKey = entry.getKey();
                leastFrequency = entry.getValue();
            }
        }

        cacheData.remove(minKey);
        System.out.println("evicte value from low_level_design.cache " + minKey);
        return true;
    }
}
