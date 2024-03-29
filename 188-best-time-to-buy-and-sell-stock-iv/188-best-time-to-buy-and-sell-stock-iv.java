class Solution {
    public int maxProfit(int k, int[] prices) {
        //return maxProfitKSpace(k, prices);
        return maxProfitNKSpace(k, prices);
    }
    
    private int maxProfitKSpace(int k, int[] prices) {
        int[] cost = new int[k+1];
        int[] profit = new int[k+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        for(int i=0;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                cost[j] = Math.min(cost[j], prices[i]-profit[j-1]);
                profit[j] = Math.max(profit[j], prices[i]-cost[j]);
            }
        }
        
        return profit[k];
    }
    
    private int maxProfitNKSpace(int k, int[] prices) {
        int n = prices.length;
        //3rd dimension to store weather we are holding a stock or not
        // 0 indicates not holding, 1 indicates holding;
        int dp[][][] = new int[n+1][k+1][2];
        
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=k;j++){
                for(int hold=0;hold<2;hold++){
                    int doNothing = dp[i+1][j][hold];
                    int doSomething;
                    if(hold==1){
                        doSomething = prices[i] + dp[i+1][j-1][0];
                    }else{
                        doSomething = -prices[i] + dp[i+1][j][1];
                    }
                    
                    dp[i][j][hold] = Math.max(doNothing, doSomething);
                }
            }
        }
        
        return dp[0][k][0];
    }
}