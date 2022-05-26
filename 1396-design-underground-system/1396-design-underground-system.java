class UndergroundSystem {

    class SystemDetails {
        String station;
        int time, count;
        
        public SystemDetails(int time, int count) {
            this.time = time;
            this.count = count;
        }
        
        public SystemDetails(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
    Map<Integer, SystemDetails> custMap;
    Map<String, SystemDetails> timeMap;
    public UndergroundSystem() {
        custMap = new HashMap<>();
        timeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        custMap.put(id, new SystemDetails(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        SystemDetails checkIn = custMap.get(id);
        String stations = checkIn.station+"_"+stationName;
        int time = t - checkIn.time;
        if(!timeMap.containsKey(stations)){
            timeMap.put(stations, new SystemDetails(time, 1));
        }else{
            SystemDetails val = timeMap.get(stations);
            val.time += time;
            val.count += 1;
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        SystemDetails details = timeMap.get(startStation+"_"+endStation);
        return (1.0 * details.time)/details.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */