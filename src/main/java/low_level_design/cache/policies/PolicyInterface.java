package low_level_design.cache.policies;

import java.util.Map;

public interface PolicyInterface<K,V> {
    boolean updatePolicyTable(K key);
    boolean evictFromCache(Map<K,V> cacheData);
}
