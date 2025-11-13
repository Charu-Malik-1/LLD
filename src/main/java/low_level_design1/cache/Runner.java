package low_level_design1.cache;

import low_level_design1.cache.enums.EvictionPolicyType;
import low_level_design1.cache.policies.EvictionPolicyFactory;

public class Runner {
    public static void main(String[] args) {
        EvictionPolicyFactory evictionPolicyFactory = new EvictionPolicyFactory();
        Cache cache = new Cache(2, evictionPolicyFactory.getPolicy(EvictionPolicyType.LRU));
        cache.putKey(1, 'A');
        cache.putKey(2, 'B');
        cache.getKey(1);
        cache.putKey(3, 'C');
        cache.getKey(1);
    }
}
