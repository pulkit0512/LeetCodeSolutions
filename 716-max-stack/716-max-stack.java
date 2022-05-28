class MaxStack {

    Stack<Integer> normal, max;
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
    }
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