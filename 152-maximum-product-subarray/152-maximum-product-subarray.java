class Solution {
    public int maxProduct(int[] nums) {
        int zero = 0, maxSoFar = 1, minSoFar = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero = 1;
                maxSoFar = 1;
                minSoFar = 1;
            }else{
                // having nums[i] in the subarray what are the max & min subarray product we can have
                int val = Math.max(nums[i], Math.max(maxSoFar*nums[i], minSoFar*nums[i]));
                minSoFar = Math.min(nums[i], Math.min(maxSoFar*nums[i], minSoFar*nums[i]));
                maxSoFar = val;
                ans = Math.max(ans, maxSoFar);
            }
        }
        if(zero==1 && ans<0){
            return 0;
        }
        return ans;
    }
}