class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return validPartitionMemo(nums, 0, dp);
    }
    
    private boolean validPartitionMemo(int[] nums, int idx, Boolean[] dp) {
        if(idx==nums.length){
            return true;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }
        
        boolean isPossible = false;
        if(idx<nums.length-1 && nums[idx]==nums[idx+1]){
            if(validPartitionMemo(nums, idx+2, dp)){
                dp[idx] = true;
                return true;
            }
        }
        if(idx<nums.length-2){
            if((nums[idx]==nums[idx+1] && nums[idx+1]==nums[idx+2]) || 
               (nums[idx]+1==nums[idx+1] && nums[idx+1]+1==nums[idx+2])){
                
                if(validPartitionMemo(nums, idx+3, dp)){
                    dp[idx] = true;
                    return true;
                }
            }
        }
        dp[idx] = false;
        return false;
    }
}