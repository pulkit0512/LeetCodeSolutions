class MinStack {
    /*
    val<min
    2*val<2*min
    2*val-min<min

    element pushed = 2*val-oldMin
    newMin = val

    newMin = 2*newMin - element popped
    newMin = 2*newMin - (2*val-oldMin)
    newMin = 2*val - 2*val + oldMin
    newMin = oldMin
    */

    Stack<Long> st;
    long min;
    public MinStack() {
        min = Integer.MAX_VALUE;
        st = new Stack<>();
    }
    
    public void push(int val) {
        long valLong = val;
        if(st.isEmpty()){
            st.push(valLong);
            min = valLong;
        }else if(valLong>=min){
            st.push(valLong);
        }else{
            st.push(2*valLong-min);
            min = valLong;
        }
    }
    
    public void pop() {
        if(st.peek()>=min){
            st.pop();
        }else{
            min = 2*min - st.pop();
        }
    }
    
    public int top() {
        long val = st.peek();
        if(val>=min){
            return (int)val;
        }
        return (int)min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */