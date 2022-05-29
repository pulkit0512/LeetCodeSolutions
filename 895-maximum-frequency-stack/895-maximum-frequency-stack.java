class FreqStack {

    Map<Integer, Integer> freq;
    Map<Integer, List<Integer>> freqSt;
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
            freqSt.put(k+1, new ArrayList<>());
            maxFreq = k+1;
        }
        freqSt.get(k+1).add(val);
    }
    
    public int pop() {
        //System.out.println(freq+" "+freqSt);
        List<Integer> list = freqSt.get(maxFreq);
        int val = list.remove(list.size()-1);
        int k = freq.get(val);
        if(k==1){
            freq.remove(val);
        }else{
            freq.put(val, k-1);
        }
        if(list.isEmpty()){
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