class Solution {
    public int rob(int[] nums) {
        int inc = nums[0];
        int exc = 0;
        for(int i=1;i<nums.length;i++){
            int temp = inc;
            inc = exc + nums[i];
            exc = Math.max(temp, exc);
        }
        return Math.max(inc, exc);
    }
}