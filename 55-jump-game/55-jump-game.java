class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1){
            return true;
        }
        int reach = nums[0];
        for(int i=0;i<=reach;i++){
            reach = Math.max(reach, nums[i]+i);
            if(reach>=n-1){
                return true;
            }
        }
        return false;
    }
}