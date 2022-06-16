class Solution {
    public long maxAlternatingSum(int[] nums) {
        long plus = nums[0], minus = 0;
        long val;
        for(int i=1;i<nums.length;i++){
            val = Math.max(minus + nums[i], plus);
            minus = Math.max(plus - nums[i], minus);
            plus = val;
        }
        return Math.max(plus, minus);
    }
}