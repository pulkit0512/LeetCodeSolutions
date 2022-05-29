class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> freqSt;
    int maxFreq;
    public FreqStack() {
        freq = new HashMap<>();
        freqSt = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        if(!freq.containsKey(val)){
            freq.put(val, 0);
        }
        int k = freq.get(val);
        freq.put(val, k+1);
        if(!freqSt.containsKey(k+1)){
            freqSt.put(k+1, new Stack<>());
            maxFreq = k+1;
        }
        freqSt.get(k+1).push(val);
    }
    
    public int pop() {
        //System.out.println(freq+" "+freqSt);
        int val = freqSt.get(maxFreq).pop();
        int k = freq.get(val);
        if(k==1){
            freq.remove(val);
        }else{
            freq.put(val, k-1);
        }
        if(freqSt.get(maxFreq).isEmpty()){
            freqSt.remove(maxFreq);
            maxFreq--;
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