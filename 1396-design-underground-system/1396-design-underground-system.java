class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> custMap;
    Map<String, Pair<Integer, Integer>> timeMap;
    public UndergroundSystem() {
        custMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        custMap.put(id, new Pair(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = custMap.get(id);
        String stations = checkIn.getKey()+"_"+stationName;
        int time = t - checkIn.getValue();
        if(!timeMap.containsKey(stations)){
            timeMap.put(stations, new Pair(time, 1));
        }else{
            Pair<Integer, Integer> val = timeMap.get(stations);
            timeMap.put(stations, new Pair(val.getKey() + time, val.getValue() + 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> times = timeMap.get(startStation+"_"+endStation);
        return (1.0 * times.getKey())/times.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */