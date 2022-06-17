class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int dp[] = new int[days[n-1] + 1];
        for(int i=1, j=0;i<=days[n-1];i++){
            if(i==days[j]){
                dp[i] = dp[i-1] + costs[0];
                if(i>=7){
                    dp[i] = Math.min(dp[i], dp[i-7]+costs[1]);
                }else{
                    dp[i] = Math.min(dp[i], costs[1]);
                }
                if(i>=30){
                    dp[i] = Math.min(dp[i], dp[i-30]+costs[2]);
                }else{
                    dp[i] = Math.min(dp[i], costs[2]);
                }
                j++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        
        return dp[days[n-1]];
    }
}