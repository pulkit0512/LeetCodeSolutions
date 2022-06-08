class CustomStack {

    List<Integer> main;
    int size;
    public CustomStack(int maxSize) {
        main = new ArrayList<>();
        size = maxSize;
    }
    
    public void push(int x) {
        if(size==main.size()){
            return;
        }
        main.add(x);
    }
    
    public int pop() {
        if(main.isEmpty()){
            return -1;
        }
        return (int)main.remove(main.size()-1);
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(k, main.size());i++){
            main.set(i, main.get(i)+val);
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