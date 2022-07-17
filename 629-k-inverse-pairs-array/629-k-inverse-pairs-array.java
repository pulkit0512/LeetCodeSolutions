class Solution {
    int mod = 1000000007;
    public int kInversePairs(int n, int k) {
        return kInversePairsUsingCumulativeSumN2Space(n, k);
    }
    
    private int kInversePairsUsingCumulativeSumN2Space(int n, int k) {
        int dp[][] = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                if(j==0){
                    dp[i][j] = 1;
                }else{
                    int val = dp[i-1][j];
                    if(j-i>=0){
                        val = val - dp[i-1][j-i];
                        if(val<0){
                            val = val + mod;
                        }
                    }
                    val = val%mod;
                    dp[i][j] = (dp[i][j-1] + val)%mod;
                }
            }
        }
        int ans = dp[n][k];
        if(k-1>=0){
            ans = ans-dp[n][k-1];
            if(ans<0){
                ans = ans + mod;
            }
        }
        return ans%mod;
    }
}