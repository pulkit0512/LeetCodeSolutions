class Solution {
    public int rob(int[] nums) {
        int inc = nums[0];
        int exc = 0;
        for(int i=1;i<nums.length-1;i++){
            int temp = exc + nums[i];
            exc = Math.max(inc, exc);
            inc = temp;
        }
        int ans = Math.max(inc, exc);
        inc = nums[nums.length-1];
        exc = 0;
        for(int i=nums.length-2;i>0;i--){
            int temp = exc + nums[i];
            exc = Math.max(inc, exc);
            inc = temp;
        }
        ans = Math.max(ans, Math.max(inc, exc));
        return ans;
    }
}