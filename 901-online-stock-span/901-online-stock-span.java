class StockSpanner {

    Stack<Pair<Integer, Integer>> st;
    int idx;
    public StockSpanner() {
        st = new Stack();
        st.push(new Pair(Integer.MAX_VALUE, -1));
        idx = 0;
    }
    
    public int next(int price) {
        //System.out.println(st);
        while(st.peek().getKey()<=price){
            st.pop();
        }
        int ans = idx-st.peek().getValue();
        st.push(new Pair(price,idx));
        idx++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */