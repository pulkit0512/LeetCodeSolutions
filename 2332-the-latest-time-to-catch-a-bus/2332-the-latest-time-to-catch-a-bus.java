class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int idx = 0;
        for(int i=0;i<passengers.length;i++){
            int time = passengers[i];
            while(idx<buses.length && time>buses[idx]){
                idx++;
            }
            if(idx==buses.length){
                break;
            }
            map.put(buses[idx], map.getOrDefault(buses[idx], 0) + 1);
            list.add(time);
            set.add(time);
            if(map.get(buses[idx])==capacity){
                idx++;
            }
        }
        //System.out.println(map);
        //System.out.println(list);
        int ans = 1;
        for(int i=list.size()-1;i>=0;i--){
            int upper = list.get(i);
            int lower = (i-1>=0?list.get(i-1):0);
            if(upper-lower>1){
                ans = upper-1;
                break;
            }
        }
        for(int i=buses.length-1;i>=0;i--){
            if((map.containsKey(buses[i]) && map.get(buses[i])==capacity) || set.contains(buses[i])){
                continue;
            }
            if(buses[i]>ans){
                ans = buses[i];
                break;
            }
        }
        return ans;
    }
}