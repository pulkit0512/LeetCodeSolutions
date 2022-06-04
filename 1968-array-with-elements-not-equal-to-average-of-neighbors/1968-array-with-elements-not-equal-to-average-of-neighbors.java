class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        for(int idx=0;idx<nums.length;idx+=2){
            ans[idx] = nums[i++];
            if(idx+1<nums.length){
                ans[idx+1] = nums[j--];
            }
        }
        return ans;
    }
}