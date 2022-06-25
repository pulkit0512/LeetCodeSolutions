class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                if((i+1<nums.length && nums[i+1]>=nums[i-1]) || (i+1>=nums.length) || (i-2>=0 && nums[i]>=nums[i-2]) || (i-2<0)){
                    modified++;
                }else{
                    modified +=2;
                }
            }
        }
        return modified<=1;
    }
}