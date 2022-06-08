class CustomStack {

    Deque<Integer> main;
    Stack<Integer> stack;
    int size;
    public CustomStack(int maxSize) {
        main = new LinkedList<>();
        stack = new Stack<>();
        size = maxSize;
    }
    
    public void push(int x) {
        if(size==main.size()){
            return;
        }
        main.addLast(x);
    }
    
    public int pop() {
        if(main.isEmpty()){
            return -1;
        }
        return (int)main.pollLast();
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && !main.isEmpty();i++){
            stack.push(main.pollFirst() + val);
        }
        for(int i=0;i<k && !stack.isEmpty();i++){
            main.addFirst(stack.pop());
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */