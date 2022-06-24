class CountIntervals {

    TreeMap<Integer, Integer> map;
    int cnt;
    public CountIntervals() {
        map = new TreeMap<>();
        cnt = 0;
    }
    
    public void add(int left, int right) {
        while(true){
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(right);
            int floorVal = floorEntry==null?0:floorEntry.getValue();
            if(floorEntry==null || floorVal<left){
                break;
            }
            int floorKey = floorEntry.getKey();
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