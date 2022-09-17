class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int m = multipliers.length;
        int n = nums.length;
        
        int dp[] = new int[m+1];
        for(int opr=m-1;opr>=0;opr--){
            int cur[] = new int[m+1];
            for(int left=0; left<=opr; left++) {
                int right = n-1 - (opr-left);
                
                // dp[op][left] stores the maximum possible score after we have done op total operations
                // and used left numbers from the left/start side.
                cur[left] = Math.max(nums[left]*multipliers[opr] + dp[left+1],
                                        nums[right]*multipliers[opr] + dp[left]);
            }
            
            dp = cur;
        }
        
        return dp[0];
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