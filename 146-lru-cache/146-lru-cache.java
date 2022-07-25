class LRUCache {
    class DLLNode {
        int key, val;
        DLLNode prev, next;
        
        public DLLNode(int a, int b) {
            key = a;
            val = b;
            prev = next = null;
        }
    }
    
    public void addNode(DLLNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    public void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void moveToTop(DLLNode node) {
        removeNode(node);
        addNode(node);
    }
    
    public DLLNode removeLast() {
        DLLNode node = tail.prev;
        removeNode(node);
        return node;
    }
    
    DLLNode head, tail;
    Map<Integer, DLLNode> cache;
    int capacity;

    public LRUCache(int capacity) {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        DLLNode node = cache.get(key);
        moveToTop(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.val = value;
            moveToTop(node);
        }else{
            if(cache.size()==capacity){
                DLLNode node = removeLast();
                cache.remove(node.key);
            }
            DLLNode node = new DLLNode(key, value);
            addNode(node);
            cache.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */