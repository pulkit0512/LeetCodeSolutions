class Solution {
    public int[] rearrangeArray(int[] nums) {
        //return rearrangeArrayUsingExtraSpace(nums);
        return rearrangeArrayInPlace(nums);
    }
    private int[] rearrangeArrayUsingExtraSpace(int[] nums) {
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
    private int[] rearrangeArrayInPlace(int[] nums) {
        int dir = 0; // 0 indicates next element should be greater and 1 indicates next element should be smaller.
        for(int i=0;i<nums.length-1;i++){
            if(dir==0){
                if(nums[i]>nums[i+1]){
                    swap(nums, i, i+1);
                }
                dir = 1;
            }else {
                if(nums[i]<nums[i+1]){
                    swap(nums, i, i+1);
                }
                dir = 0;
            }
        }
        return nums;
    }
    private void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}