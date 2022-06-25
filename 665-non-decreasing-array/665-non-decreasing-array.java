class Solution {
    public boolean checkPossibility(int[] nums) {
        int modified = 0;
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                if((i+1<n && nums[i+1]>=nums[i-1]) || (i+1>=n) || (i-2>=0 && nums[i]>=nums[i-2]) || (i-2<0)){
                    modified++;
                }else{
                    modified +=2;
                }
                
                if(modified>1){
                    return false;
                }
            }
        }
        return true;
    }
}