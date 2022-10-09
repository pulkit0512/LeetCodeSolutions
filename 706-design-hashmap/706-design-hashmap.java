class MyHashMap {
    
    CustomHashMap<Integer, Integer> map;
    public MyHashMap() {
        map = new CustomHashMap<>();
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
    
    public int get(int key) {
        return map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void remove(int key) {
        map.remove(key);
    }
}

class CustomHashMap<K, V> {
    private class HMNode {
        K key;
        V value;

        HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public CustomHashMap() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        HMNode node = findNodeInBucket(key, bucketIndex);
        if(node==null){
            buckets[bucketIndex].add(new HMNode(key, value));
            size++;
        }else{
            node.value = value;
        }
        if((size*1.0)/buckets.length>2.0) {
            rehash();
        }
    }
    
    private void rehash() {
        LinkedList<HMNode>[] oldBuckets = buckets;
        initbuckets(2*buckets.length);
        size = 0;
        
        for(int i=0;i<oldBuckets.length;i++){
            for(HMNode node:oldBuckets[i]){
                put(node.key, node.value);
            }
        }
    }
    
    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode)%buckets.length;
    }
    
    private HMNode findNodeInBucket(K key, int bucketIndex) {
        for(HMNode node:buckets[bucketIndex]) {
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    public V get(K key) {
        int bucketIndex = hashFunction(key);
        HMNode node = findNodeInBucket(key, bucketIndex);
    
        return node!=null ? node.value : null;
    }

    public boolean containsKey(K key) {
        int bucketIndex = hashFunction(key);
        HMNode node = findNodeInBucket(key, bucketIndex);
    
        return node!=null;
    }

    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        HMNode node = findNodeInBucket(key, bucketIndex);
        if(node==null){
            return null;
        }
    
        size--;
        buckets[bucketIndex].remove(node);
        return node.value;
    }

    public ArrayList<K> keyset() {
        ArrayList<K> keys = new ArrayList<>();
        for(int i=0;i<buckets.length;i++){
            for(HMNode node:buckets[i]){
                keys.add(node.key);
            }
        }
        return keys;
    }

    public int size() {
        return size;
    }
    
    public void display() {
        System.out.println("Display Begins");
        for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
            System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
        }
        System.out.println("Display Ends");
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */