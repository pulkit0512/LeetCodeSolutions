class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sPrev = 0, sCurr = 0;
        int cool = 0;
        int bPrev = -prices[0], bCurr = 0;
        for(int i=1;i<n;i++){
            bCurr = Math.max(bPrev, cool-prices[i]);//Buy on previous cool
            sCurr = Math.max(sPrev, bPrev+prices[i]);//Sell on previous best buy.
            cool = sPrev;// Since sell will become cooldown for next day.
            sPrev = sCurr;
            bPrev = bCurr;
        }
        return sPrev;
    }
}