class Solution {
    Integer[][] memo;
    int n, k, target;
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        if(target<n || target>n*k){
            return 0;
        }
        //return numRollsToTargetMemo(n, k, target);
        
        return numRollsToTargetTabulation(n, k, target);
    }
    
    private int numRollsToTargetTabulation(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        dp[n][target] = 1;
        
        for(int diceIndex=n-1;diceIndex>=0;diceIndex--){
            for(int curSum=0;curSum<=target;curSum++){
                int ways = 0;
                for(int i=1;i<=Math.min(k, target-curSum);i++){
                    ways = (ways + dp[diceIndex+1][curSum+i])%mod;
                }
                dp[diceIndex][curSum] = ways;
            }
        }
        
        return dp[0][0];
    }
    
    private int numRollsToTargetMemo(int n, int k, int target) {
        memo = new Integer[n+1][target+1];
        this.k = k;
        this.n = n;
        this.target = target;
        
        return numRollsToTargetMemoUtil(0, 0);
    }
    
    private int numRollsToTargetMemoUtil(int diceIndex, int curSum) {
        if(diceIndex==n){
            return curSum==target?1:0;
        }
        
        if(memo[diceIndex][curSum]!=null){
            return memo[diceIndex][curSum];
        }
        
        int ways = 0;
        for(int i=1;i<=Math.min(k, target-curSum);i++){
            ways = (ways + numRollsToTargetMemoUtil(diceIndex+1, curSum+i))%mod;
        }
        
        return memo[diceIndex][curSum] = ways;
    }
}