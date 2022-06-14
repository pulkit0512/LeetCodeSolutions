class Solution {
    public int maxProfit(int[] prices, int fee) {
        int bPrev = -prices[0], bCurr = 0;
        int sPrev = 0, sCurr = 0;
        for(int i=1;i<prices.length;i++){
            bCurr = Math.max(bPrev, sPrev-prices[i]);
            sCurr = Math.max(sPrev, prices[i]+bPrev-fee);
            
            bPrev = bCurr;
            sPrev = sCurr;
        }
        return sPrev;
    }
}