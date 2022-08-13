class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int st, int ed) {
        while(st<ed){
            int temp = nums[st];
            nums[st] = nums[ed];
            nums[ed] = temp;
            st++;
            ed--;
        }
    }
}