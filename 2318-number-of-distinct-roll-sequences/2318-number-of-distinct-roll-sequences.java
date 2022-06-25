class Solution {
    long dp[][][];
    int mod = 1000000007;
    int n;
    public int distinctSequences(int n) {
        this.n = n;
        dp = new long[n][6][6];
        long ans = 0;
        for(int i=0;i<6;i++){
            dp[0][i][i] = getCount(i+1, 1, i+1);
            ans = (ans + dp[0][i][i])%mod;
        }
        return (int)ans;
    }
    
    private long getCount(int prev, int len, int secondPrev) {
        if(len==n){
            return 1;
        }
        if(dp[len][prev-1][secondPrev-1]!=0){
            return dp[len][prev-1][secondPrev-1];
        }
        long val = 0;
        for(int i=1;i<=6;i++){
            if(i==prev || i==secondPrev){
                continue;
            }
            int gcd = getGcd(prev, i);
            if(gcd==1){
                val = (val + getCount(i, len+1, prev))%mod;
            }
        }
        dp[len][prev-1][secondPrev-1] = val;
        return val;
    }
    
    private int getGcd(int a, int b){
        if(b==0){
            return a;
        }
        return getGcd(b, a%b);
    }
}