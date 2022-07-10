class MyQueue {

    // pop O(1) push Amortized O(1)
    Stack<Integer> st1, st2;
    int front;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        front = -1;
    }
    
    public void push(int x) {
        if(st1.isEmpty()){
            front = x;
        }
        st1.push(x);
    }
    
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
        
    }
    
    public int peek() {
        if(!st2.isEmpty()){
            return st2.peek();
        }else{
            return front;
        }
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */