class TimeMap {

    Map<String, List<Pair<Integer, String>>> kvStore;
    public TimeMap() {
        kvStore = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!kvStore.containsKey(key)){
            kvStore.put(key, new ArrayList<>());
        }
        
        kvStore.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> pairList = kvStore.get(key);
        if(pairList==null) {
            return "";
        }
        
        return binarySearch(pairList, timestamp);
    }
    
    private String binarySearch(List<Pair<Integer, String>> pairList, int timestamp) {
        int st = 0, ed = pairList.size()-1;
        int idx = -1;
        while(st<=ed){
            int mid = (st+ed)/2;
            if(pairList.get(mid).getKey()<=timestamp){
                idx = mid;
                if(pairList.get(mid).getKey()==timestamp){
                    break;
                }
                st = mid+1;
            }else{
                ed = mid-1;
            }
        }
        
        return idx==-1 ? "" : pairList.get(idx).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */