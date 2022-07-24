class SmallestInfiniteSet {

    Set<Integer> set;
    public SmallestInfiniteSet() {
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        int cnt = 1;
        while(set.contains(cnt)){
            cnt++;
        }
        set.add(cnt);
        return cnt;
    }
    
    public void addBack(int num) {
        set.remove(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */