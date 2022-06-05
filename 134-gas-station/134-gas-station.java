class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0, cur = 0;
        int st = 0;
        for(int i=0;i<n;i++){
            total += gas[i]-cost[i];
            cur += gas[i]-cost[i];
            if(cur<0){
                st = (i+1)%n;
                cur = 0;
            }
        }
        return total>=0?st:-1;
    }
}