class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long memo[][] = new long[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i], -1);
        }
        int p[][] = new int[m+1][n+1];
        for(int price[]:prices){
            p[price[0]][price[1]] = price[2];
        }
        
        return dp(m, n, p, memo);
    }
    
    private long dp(int i, int j, int[][] p, long[][] memo) {
        if(i==0||j==0){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        long ans = p[i][j];
        // Make horizontal cuts for current i, j
        for(int idx = 1;idx<i;idx++){
            ans = Math.max(ans, dp(idx, j, p, memo) + dp(i-idx, j, p, memo));
        }
        
        // Make vertical cuts for current i, j
        for(int idx = 1;idx<j;idx++){
            ans = Math.max(ans, dp(i, idx, p, memo) + dp(i, j-idx, p, memo));
        }
        
        return memo[i][j] = ans;
    }
}