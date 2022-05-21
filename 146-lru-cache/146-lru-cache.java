class LRUCache {
    class DLLNode{
        int key, val;
        DLLNode next, prev;
        DLLNode(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    private void addNode(DLLNode node){
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }
    
    private void removeNode(DLLNode node){
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveNodeToTop(DLLNode node){
        removeNode(node);
        addNode(node);
    }
    
    private int removeLast(){
        DLLNode prev = tail.prev;
        removeNode(prev);
        return prev.key;
    }
    
    Map<Integer, DLLNode> cache;
    int capacity;
    DLLNode head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLLNode node = cache.get(key);
        if(node==null){
            return -1;
        }
        moveNodeToTop(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLLNode node = cache.get(key);
        if(node == null){
            DLLNode newNode = new DLLNode(key, value);
            addNode(newNode);
            cache.put(key, newNode);
            if(cache.size()>capacity){
                int lastKey = removeLast();
                cache.remove(lastKey);
            }
        }else{
            node.val = value;
            moveNodeToTop(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */