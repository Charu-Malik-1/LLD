//package low_level_design.cache.policies;
//
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class FIFOPolicy{// implements PolicyInterface {
//
//// maintain insertion order
//    @Override
//    public Object getKey(String key, LinkedHashMap<String, Object> cacheData) {
//        if (cacheData.containsKey(key)) {
//            Object ob = cacheData.get(key);
//            cacheData.remove(key);
//            cacheData.put(key, ob);
//            System.out.println("FIFO low_level_design.cache hit");
//            return ob;
//        } else {
//            System.out.println("FIFO low_level_design.cache miss");
//        }
//        return null;
//    }
//
//    @Override
//    public Object getKey(Object key, LinkedHashMap cacheData) {
//        return null;
//    }
//
//    public void setKey(String key, Object value, LinkedHashMap<String, Object> cacheData, int maxSize) {
//        int currentSize = cacheData.size();
//        if (currentSize == maxSize) {
//            Iterator<Map.Entry<String, Object>> it = cacheData.entrySet().iterator();
//
//            Map.Entry<String, Object> lastEntry = null;
//            while (it.hasNext()) {
//                lastEntry = it.next();
//            }
//
//            if (lastEntry != null) {
//                cacheData.remove(lastEntry.getKey());
//            }
//        }
//        cacheData.put(key, value);
//    }
//}
