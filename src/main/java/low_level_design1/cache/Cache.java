package low_level_design1.cache;

import low_level_design1.cache.policies.PolicyInterface;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Cache<K, V> {
    private final int maxSize;
    private Map<K, V> cacheData;
    private final PolicyInterface<K,V> evictonPolicy;

    public Cache(int size, PolicyInterface<K,V> policyInterface) {
        this.maxSize = size;
        cacheData = new HashMap<>();
        evictonPolicy = policyInterface;
    }

    public void getKey(K key) {
        if (cacheData != null && cacheData.get(key) == null) {
            System.out.println("low_level_design.cache miss");
        } else {
            evictonPolicy.updatePolicyTable(key);
            System.out.println("cahche hit=" + cacheData.get(key));
        }
    }

    public void putKey(K key, V value) {
        if (cacheData.containsKey(key)) {
            evictonPolicy.updatePolicyTable(key);
        } else {
            if (cacheData.size() == maxSize) {
                // evict from low_level_design.cache
                if (!evictonPolicy.evictFromCache(cacheData)) {
                    return;
                }
            }
            //insert value in low_level_design.cache
            cacheData.put(key, value);

            //update policy table of low_level_design.cache data
            evictonPolicy.updatePolicyTable(key);
        }
    }
}
