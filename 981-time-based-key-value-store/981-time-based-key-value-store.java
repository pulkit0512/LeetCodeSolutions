class TimeMap {

    Map<String, List<Pair<Integer, String>>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        List<Pair<Integer, String>> values = timeMap.get(key);
        int st = 0, ed = values.size()-1;
        Pair<Integer, String> pair = null;
        while(st<=ed){
            int mid = (st+ed)/2;
            if((int)values.get(mid).getKey()<=timestamp){
                pair = values.get(mid);
                if((int)values.get(mid).getKey()==timestamp){
                    break;
                }
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }
        return pair == null ? "" : pair.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */