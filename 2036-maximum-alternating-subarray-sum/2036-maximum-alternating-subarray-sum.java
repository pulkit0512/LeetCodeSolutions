class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        int n = nums.length;
        long prevPlus = nums[0], currPlus = 0;
        long prevMinus = 0, currMinus = 0;
        long ans = nums[0];
        for(int i=1;i<n;i++){
            currPlus = Math.max(prevMinus + nums[i], nums[i]);
            currMinus = prevPlus - nums[i];
            ans = Math.max(ans, Math.max(currPlus, currMinus));
            prevPlus = currPlus;
            prevMinus = currMinus;
        }
        return ans;
    }
}