class MaxStack {
    
    class Node {
        int val;
        Node next, prev;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    class DLL {
        Node head, tail;
        
        public DLL() {
            head = new Node(0);
            tail = new Node(0);
            
            head.next = tail;
            tail.prev = head;
        }
        
        public Node add(int x) {
            Node node = new Node(x);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            return node;
        }
        
        public int peek() {
            return tail.prev.val;
        }
        
        public int pop() {
            int val = tail.prev.val;
            delete(tail.prev);
            return val;
        }
        
        public void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    DLL dll;
    TreeMap<Integer, List<Node>> map;
    public MaxStack() {
        dll = new DLL();
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        Node node = dll.add(x);
        if(!map.containsKey(x)){
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }
    
    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val);
        list.remove(list.size()-1);
        if(list.isEmpty()){
            map.remove(val);
        }
        return val;
    }
    
    public int top() {
        return dll.peek();
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int val = peekMax();
        List<Node> list = map.get(val);
        Node node = list.remove(list.size() - 1);
        dll.delete(node);
        if(list.isEmpty()){
            map.remove(val);
        }
        return val;
    }

    /*Stack<Integer> normal, max;
    public MaxStack() {
        normal = new Stack<>();
        max = new Stack<>();
    }
    
    public void push(int x) {
        normal.push(x);
        if(max.isEmpty() || max.peek()<x){
            max.push(x);
        }else{
            max.push(max.peek());
        }
    }
    
    public int pop() {
        max.pop();
        return normal.pop();
    }
    
    public int top() {
        return normal.peek();
    }
    
    public int peekMax() {
        return max.peek();
    }
    
    public int popMax() {
        int val = max.peek();
        Stack<Integer> temp = new Stack<>();
        while(normal.peek()!=val){
            temp.push(pop());
        }
        pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return val;
    }*/
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */