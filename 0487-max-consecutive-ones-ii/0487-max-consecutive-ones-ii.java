class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int st = 0, prev = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && prev == -1) {
                prev = i;
            }else if(nums[i]==0 && prev!=-1){
                max = Math.max(max, i-st);
                st = prev+1;
                prev = i;
            }
        }
        
        max = Math.max(max, nums.length-st);
        return max;
    }
}