class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> freqStack;
    int mf = 0;
    public FreqStack() {
        freqMap = new HashMap<>();
        freqStack = new HashMap<>();
    }
    
    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        int k = freqMap.get(val);
        if(!freqStack.containsKey(k)){
            freqStack.put(k, new Stack<>());
        }
        freqStack.get(k).push(val);
        mf = Math.max(mf, k);
    }
    
    public int pop() {
        Stack<Integer> mfStack = freqStack.get(mf);
        int val = mfStack.pop();
        freqMap.put(val, freqMap.get(val)-1);
        if(mfStack.isEmpty()){
            mf--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */