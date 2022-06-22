class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        //return sellingWoodTopDown(m, n, prices);
        return sellingWoodBottomUp(m, n, prices);
    }
    
    private long sellingWoodBottomUp(int m, int n, int[][] prices) {
        int p[][] = new int[m+1][n+1];
        long dp[][] = new long[m+1][n+1];
        for(int price[]:prices){
            p[price[0]][price[1]] = price[2];
        }
        for(int h=1;h<=m;h++){
            for(int w=1;w<=n;w++){
                dp[h][w] = p[h][w];
                for(int x=1;x<=w/2;x++){
                    dp[h][w] = Math.max(dp[h][w], dp[h][x] + dp[h][w-x]);
                }
                for(int x=1;x<=h/2;x++){
                    dp[h][w] = Math.max(dp[h][w], dp[x][w] + dp[h-x][w]);
                }
            }
        }
        return dp[m][n];
    }
    
    private long sellingWoodTopDown(int m, int n, int[][] prices) {
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
        for(int idx = 1;idx<=i/2;idx++){
            ans = Math.max(ans, dp(idx, j, p, memo) + dp(i-idx, j, p, memo));
        }
        
        // Make vertical cuts for current i, j
        for(int idx = 1;idx<=j/2;idx++){
            ans = Math.max(ans, dp(i, idx, p, memo) + dp(i, j-idx, p, memo));
        }
        
        return memo[i][j] = ans;
    }
}