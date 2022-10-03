class Solution {
    Integer[][] memo;
    int n, k, target;
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n+1][target+1];
        this.k = k;
        this.n = n;
        this.target = target;
        
        return numRollsToTargetMemo(0, 0);
    }
    
    private int numRollsToTargetMemo(int diceIndex, int curSum) {
        if(diceIndex==n){
            return curSum==target?1:0;
        }
        
        if(memo[diceIndex][curSum]!=null){
            return memo[diceIndex][curSum];
        }
        
        int ways = 0;
        for(int i=1;i<=Math.min(k, target-curSum);i++){
            ways = (ways + numRollsToTargetMemo(diceIndex+1, curSum+i))%mod;
        }
        
        return memo[diceIndex][curSum] = ways;
    }
}