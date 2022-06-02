class TwoSum {

    Map<Integer, Integer> map;
    public TwoSum() {
        map = new HashMap<>();
    }
    
    public void add(int number) {
        if(!map.containsKey(number)){
            map.put(number, 1);
        }else{
            map.put(number, map.get(number)+1);
        }
    }
    
    public boolean find(int value) {
        for(int x:map.keySet()){
            int next = value-x;
            if(next==x && map.get(next)<2){
                continue;
            }
            if(map.containsKey(value-x)){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */