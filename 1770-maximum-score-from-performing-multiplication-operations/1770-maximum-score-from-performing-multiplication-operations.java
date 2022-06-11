class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        int[][] dp = new int[m+1][m+1];
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                int ed = n - 1 - (i-j);
                dp[i][j] = Math.max(multipliers[i]*nums[j] + dp[i+1][j+1], multipliers[i]*nums[ed] + dp[i+1][j]);
            }
        }
        return dp[0][0];
    }
    
    // DP with memoization
    /*int[][] dp;
    int nums[], multipliers[];
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new int[1000][1000];
        this.nums = nums;
        this.multipliers = multipliers;
        return maximumScoreUtil(0, 0);
    }
    
    private int maximumScoreUtil(int idx, int st) {
        //System.out.println(st+" "+ed);
        if(multipliers.length==idx){
            return 0;
        }
        int ed = nums.length - 1 - (idx-st);
        
        if(dp[idx][st]!=0){
            return dp[idx][st];
        }
        
        int left = nums[st]*multipliers[idx] + maximumScoreUtil(idx+1, st+1);
        int right = nums[ed]*multipliers[idx] + maximumScoreUtil(idx+1, st);
        
        dp[idx][st] = Math.max(left, right);
        return dp[idx][st];
    }*/
}