class LFUCache {

    Map<Integer, Integer> cache, keyCount;
    Map<Integer, Set<Integer>> freqMap;
    int min, cap;
    public LFUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        keyCount = new HashMap<>();
        freqMap = new HashMap<>();
        min = 0;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int count = keyCount.get(key);
        keyCount.put(key, count+1);
        freqMap.get(count).remove(key);
        if(count==min && freqMap.get(count).isEmpty()){
            min++;
            freqMap.remove(count);
        }
        if(!freqMap.containsKey(count+1)){
            freqMap.put(count+1, new LinkedHashSet<>());
        }
        freqMap.get(count+1).add(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        if(cap==0){
            return;
        }
        if(cache.containsKey(key)){
            cache.put(key, value);
            get(key);
            return;
        }
        if(cache.size()==cap){
            int evict = freqMap.get(min).iterator().next();
            freqMap.get(min).remove(evict);
            cache.remove(evict);
            keyCount.remove(evict);
            if(freqMap.get(min).isEmpty()){
                freqMap.remove(min);
            }
        }
        cache.put(key, value);
        keyCount.put(key, 1);
        min = 1;
        if(!freqMap.containsKey(min)){
            freqMap.put(min, new LinkedHashSet<>());
        }
        freqMap.get(min).add(key);
        return;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */