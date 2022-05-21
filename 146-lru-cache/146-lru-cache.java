class LRUCache {
    Map<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
        }else if(cache.size()==capacity){
            int firstKey = cache.entrySet().iterator().next().getKey();
            cache.remove(firstKey);
        }
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */