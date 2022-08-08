class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int station = 0;
        int totalGas = 0, curGas = 0;
        for(int i=0;i<gas.length;i++){
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if(curGas<0){
                curGas = 0;
                station = (i+1)%gas.length;
            }
        }
        return totalGas>=0?station:-1;
    }
}