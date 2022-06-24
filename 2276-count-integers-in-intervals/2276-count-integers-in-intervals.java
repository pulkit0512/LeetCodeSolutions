class CountIntervals {

    TreeMap<Integer, Integer> map;
    int cnt;
    public CountIntervals() {
        map = new TreeMap<>();
        cnt = 0;
    }
    
    public void add(int left, int right) {
        while(true){
            Integer floorKey = map.floorKey(right);
            int floorVal = floorKey==null?0:map.get(floorKey);
            if(floorKey==null || floorVal<left){
                break;
            }
            left = Math.min(floorKey, left);
            right = Math.max(floorVal, right);
            map.remove(floorKey);
            cnt -= (floorVal-floorKey+1);
        }
        map.put(left, right);
        cnt += (right-left+1);
    }
    
    public int count() {
        return cnt;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */