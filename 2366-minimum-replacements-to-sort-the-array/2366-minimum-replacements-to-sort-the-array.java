class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int min = nums[n-1];
        for(int i=n-1;i>=0;i--){
            int val = (int)Math.ceil(nums[i]/(1.0*min));
            ans = ans + val - 1;
            if(min>nums[i]/val){
                min = nums[i]/val;
            }
        }
        return ans;
    }
}