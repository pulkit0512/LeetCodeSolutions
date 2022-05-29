class RandomizedCollection {

    Map<Integer, Set<Integer>> map;
    List<Integer> list;
    Random rand;
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean ret = false;
        if(!map.containsKey(val)){
            map.put(val, new HashSet<>());
            ret = true;
        }
        map.get(val).add(list.size());
        list.add(val);
        return ret;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        //System.out.println(map+" "+list);
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);
        int lastEle = list.get(list.size()-1);
        list.set(idx, lastEle);
        map.get(lastEle).add(idx);
        map.get(lastEle).remove(list.size()-1);
        
        list.remove(list.size()-1);
        if(map.get(val).isEmpty()){
            map.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */