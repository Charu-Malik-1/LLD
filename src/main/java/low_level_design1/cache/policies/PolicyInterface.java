package low_level_design1.cache.policies;

import java.util.Map;

public interface PolicyInterface<K,V> {
    boolean updatePolicyTable(K key);
    boolean evictFromCache(Map<K,V> cacheData);
}
