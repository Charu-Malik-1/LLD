package low_level_design1.cache.policies;

import low_level_design1.cache.enums.EvictionPolicyType;

public class EvictionPolicyFactory {

    public PolicyInterface getPolicy(EvictionPolicyType evictionPolicyName){

        switch (evictionPolicyName){
            case LRU: return new LRUPolicy();
            case LFU: return new LFUPolicy();
            default: return new LFUPolicy();
        }
    }
}
