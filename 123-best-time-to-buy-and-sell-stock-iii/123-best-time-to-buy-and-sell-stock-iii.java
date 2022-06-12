class Solution {
    public int maxProfit(int[] prices) {
        //return maxProfitNSpace(prices);
        return maxProfitConstantSpace(prices);
    }
    
    private int maxProfitConstantSpace(int[] prices) {
        int k = 2;
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        
        for(int i=0;i<prices.length;i++){
            for(int j=1;j<=k;j++){
                buy[j] = Math.min(buy[j], prices[i]-sell[j-1]);
                sell[j] = Math.max(sell[j], prices[i]-buy[j]);
            }
        }
        
        return sell[k];
    }
    
    private int maxProfitNSpace(int[] prices) {
        int n = prices.length;
        int left[] = new int[n];
        int right[] = new int[n];
        left[0] = 0;
        right[n-1] = 0;
        int minLeft = prices[0], maxLeft = prices[0];
        int minRight = prices[n-1], maxRight = prices[n-1];
        for(int i=1;i<n;i++){
            if(prices[i]<minLeft){
                minLeft = prices[i];
                maxLeft = prices[i];
            }else if(prices[i]>maxLeft){
                maxLeft = prices[i];
            }
            
            if(prices[n-1-i]>maxRight){
                maxRight = prices[n-1-i];
                minRight = prices[n-1-i];
            }else if(prices[n-1-i]<minRight){
                minRight = prices[n-1-i];
            }
            
            left[i] = Math.max(left[i-1], maxLeft-minLeft);
            right[n-1-i] = Math.max(right[n-i], maxRight-minRight);
        }
        int maxProfit = 0;
        for(int i=0;i<n;i++){
            maxProfit = Math.max(maxProfit, left[i]+right[i]);
        }
        return maxProfit;
    }
}