class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sorted = new int[nums.length];
        int st = 0, ed = nums.length-1;
        int idx = nums.length-1;
        while(st<=ed){
            if(Math.abs(nums[ed])>=Math.abs(nums[st])){
                sorted[idx] = nums[ed]*nums[ed];
                ed--;
            }else{
                sorted[idx] = nums[st]*nums[st];
                st++;
            }
            idx--;
        }
        return sorted;
    }
}