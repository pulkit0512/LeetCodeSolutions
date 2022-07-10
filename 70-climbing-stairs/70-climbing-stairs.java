class Solution {
    int dp[] = new int[46];
    public int climbStairs(int n) {
        if(dp[n]!=0){
            return dp[n];
        }
        dp[0] = dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}