class Solution {
    int[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new int[1000][1000];
        return maximumScoreUtil(nums, multipliers, 0, 0);
    }
    
    private int maximumScoreUtil(int[] nums, int[] multipliers, int idx, int st) {
        //System.out.println(st+" "+ed);
        if(multipliers.length==idx){
            return 0;
        }
        int ed = nums.length - 1 - (idx-st);
        
        if(dp[idx][st]!=0){
            return dp[idx][st];
        }
        
        int left = nums[st]*multipliers[idx] + maximumScoreUtil(nums, multipliers, idx+1, st+1);
        int right = nums[ed]*multipliers[idx] + maximumScoreUtil(nums, multipliers, idx+1, st);
        
        dp[idx][st] = Math.max(left, right);
        return dp[idx][st];
    }
}