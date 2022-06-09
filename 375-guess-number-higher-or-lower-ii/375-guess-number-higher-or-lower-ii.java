class Solution {
    int dp[][];
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return getMaxMoney(1, n);
    }
    
    private int getMaxMoney(int st, int ed) {
        if(dp[st][ed]!=-1){
            return dp[st][ed];
        }
        if(st==ed){
            dp[st][ed] = 0;
            return 0;
        }
        if(st>ed){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int mid = (st+ed)/2;
        for(int i=mid;i<ed;i++){
            int left = getMaxMoney(st, i-1);
            int right = getMaxMoney(i+1, ed);
            ans = Math.min(ans, i+Math.max(left, right));
        }
        dp[st][ed] = ans;
        return ans;
    }
}