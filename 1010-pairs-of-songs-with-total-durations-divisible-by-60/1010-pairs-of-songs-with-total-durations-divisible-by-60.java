class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int map[] = new int[60];
        int ans = 0;
        for(int t:time){
            int val = t%60;
            if(val==0){
                ans += map[val];
            }else {
                ans += map[60-val];
            }
            map[val]++;
        }
        return ans;
    }
}