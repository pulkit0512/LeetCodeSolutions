class RandomizedSet {
    
    /* Fails some test cases.
    Map<Integer, Boolean> randomizedSet;
    public RandomizedSet() {
        randomizedSet = new LinkedHashMap<>();
    }
    
    public boolean insert(int val) {
        if(randomizedSet.containsKey(val)){
            return false;
        }else{
            randomizedSet.put(val, true);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(randomizedSet.containsKey(val)){
            randomizedSet.remove(val);
            return true;
        }else{
            return false;
        }
    }
    
    public int getRandom() {
        int firstKey = randomizedSet.entrySet().iterator().next().getKey();
        randomizedSet.remove(firstKey);
        randomizedSet.put(firstKey, true);
        return firstKey;
    }*/

    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx = map.get(val);
        int size = list.size();
        list.set(idx, list.get(size-1));
        map.put(list.get(size-1), idx);
        list.remove(size-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */