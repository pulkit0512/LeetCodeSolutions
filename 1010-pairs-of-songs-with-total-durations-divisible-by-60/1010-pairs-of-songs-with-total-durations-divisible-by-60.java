class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int t:time){
            int val = t%60;
            if(val==0 && map.containsKey(val)){
                ans += map.get(val);
            }else if(map.containsKey(60-val)) {
                ans += map.get(60-val);
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return ans;
    }
}