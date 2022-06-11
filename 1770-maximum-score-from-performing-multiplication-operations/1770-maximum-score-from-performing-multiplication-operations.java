class Solution {
    int[][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        dp = new int[1000][1000];
        return maximumScoreUtil(nums, multipliers, 0, 0, nums.length-1);
    }
    
    private int maximumScoreUtil(int[] nums, int[] multipliers, int idx, int st, int ed) {
        //System.out.println(st+" "+ed);
        if(st>ed || multipliers.length==idx){
            return 0;
        }
        if(st==ed){
            return multipliers[idx]*nums[st];
        }
        
        if(dp[idx][st]!=0){
            return dp[idx][st];
        }
        
        int left = nums[st]*multipliers[idx] + maximumScoreUtil(nums, multipliers, idx+1, st+1, ed);
        int right = nums[ed]*multipliers[idx] + maximumScoreUtil(nums, multipliers, idx+1, st, ed-1);
        
        dp[idx][st] = Math.max(left, right);
        return dp[idx][st];
    }
}