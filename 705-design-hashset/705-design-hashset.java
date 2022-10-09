class MyHashSet {

    CustomHashSet<Integer> set;
    public MyHashSet() {
        set = new CustomHashSet<>();
    }
    
    public void add(int key) {
        set.add(key);
    }
    
    public void remove(int key) {
        set.remove(key);
    }
    
    public boolean contains(int key) {
        return set.contains(key);
    }
}

class CustomHashSet<K> {
    private class HSNode {
        K key;

        HSNode(K key) {
            this.key = key;
        }
    }

    private int size; // n
    private LinkedList<HSNode>[] buckets; // N = buckets.length

    public CustomHashSet() {
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int bi = 0; bi < buckets.length; bi++) {
            buckets[bi] = new LinkedList<>();
        }
    }

    public void add(K key) {
        int bucketIndex = hashFunction(key);
        HSNode node = findNodeInBucket(key, bucketIndex);
        if(node==null){
            buckets[bucketIndex].add(new HSNode(key));
            size++;
        }else{
            node.key = key;
        }
        if((size*1.0)/buckets.length>2.0) {
            rehash();
        }
    }
    
    private void rehash() {
        LinkedList<HSNode>[] oldBuckets = buckets;
        initbuckets(2*buckets.length);
        size = 0;
        
        for(int i=0;i<oldBuckets.length;i++){
            for(HSNode node:oldBuckets[i]){
                add(node.key);
            }
        }
    }
    
    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode)%buckets.length;
    }
    
    private HSNode findNodeInBucket(K key, int bucketIndex) {
        for(HSNode node:buckets[bucketIndex]) {
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    public boolean contains(K key) {
        int bucketIndex = hashFunction(key);
        HSNode node = findNodeInBucket(key, bucketIndex);
    
        return node!=null;
    }

    public K remove(K key) {
        int bucketIndex = hashFunction(key);
        HSNode node = findNodeInBucket(key, bucketIndex);
        if(node==null){
            return null;
        }
    
        size--;
        buckets[bucketIndex].remove(node);
        return node.key;
    }

    public int size() {
        return size;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */