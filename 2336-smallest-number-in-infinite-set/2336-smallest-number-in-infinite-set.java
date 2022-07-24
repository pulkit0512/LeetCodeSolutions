class SmallestInfiniteSet {

    int[] nums;
    public SmallestInfiniteSet() {
        nums = new int[1001];
    }
    
    public int popSmallest() {
        int cnt = 1;
        while(nums[cnt]!=0){
            cnt++;
        }
        nums[cnt] = 1;
        return cnt;
    }
    
    public void addBack(int num) {
        nums[num] = 0;
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */