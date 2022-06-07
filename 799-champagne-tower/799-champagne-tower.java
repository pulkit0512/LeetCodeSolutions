class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        return champagneTowerN2Space(poured, query_row, query_glass);
        //return champagneTowerNSpace(poured, query_row, query_glass);
    }
    
    private double champagneTowerN2Space(int poured, int query_row, int query_glass) {
        double dp[][] = new double[query_row+1][query_row+1];
        dp[0][0] = (double)poured;
        for(int i=0;i<query_row;i++){
            for(int j=0;j<=i;j++){
                double rem = (dp[i][j]-1)/2.0;
                if(rem>0){
                    dp[i+1][j] += rem;
                    dp[i+1][j+1] += rem;
                }
            }
        }
        return Math.min(1.0, dp[query_row][query_glass]);
    }
    
    private double champagneTowerNSpace(int poured, int query_row, int query_glass) {
        double dpPrev[] = new double[query_row+1];
        double dpCurr[] = new double[query_row+1];
        dpPrev[0] = (double)poured;
        for(int i=0;i<query_row;i++){
            for(int j=0;j<=i;j++){
                double rem = (dpPrev[j]-1)/2.0;
                if(rem>0){
                    dpCurr[j] += rem;
                    dpCurr[j+1] += rem;
                }
            }
            for(int j=0;j<=i+1;j++){
                dpPrev[j] = dpCurr[j];
                dpCurr[j] = 0;
            }
        }
        return Math.min(1.0, dpPrev[query_glass]);
    }
}