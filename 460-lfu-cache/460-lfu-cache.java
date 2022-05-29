class LFUCache {
    class Pair {
        int val, keyCount;
        public Pair(int val, int keyCount) {
            this.val = val;
            this.keyCount = keyCount;
        }
    }

    Map<Integer, Pair> cache;
    Map<Integer, Set<Integer>> freqMap;
    int min, cap;
    public LFUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        min = 0;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int count = cache.get(key).keyCount;
        cache.get(key).keyCount++;
        freqMap.get(count).remove(key);
        if(count==min && freqMap.get(count).isEmpty()){
            min++;
            freqMap.remove(count);
        }
        if(!freqMap.containsKey(count+1)){
            freqMap.put(count+1, new LinkedHashSet<>());
        }
        freqMap.get(count+1).add(key);
        return cache.get(key).val;
    }
    
    public void put(int key, int value) {
        if(cap==0){
            return;
        }
        if(cache.containsKey(key)){
            cache.get(key).val = value;
            get(key);
            return;
        }
        if(cache.size()==cap){
            int evict = freqMap.get(min).iterator().next();
            freqMap.get(min).remove(evict);
            cache.remove(evict);
            if(freqMap.get(min).isEmpty()){
                freqMap.remove(min);
            }
        }
        cache.put(key, new Pair(value, 1));
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