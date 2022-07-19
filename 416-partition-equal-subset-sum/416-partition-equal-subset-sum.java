class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2==1){
            return false;
        }
        boolean dpPrev[] = new boolean[sum/2 + 1];
        dpPrev[0] = true;
        for(int i=0;i<nums.length;i++){
            boolean dpCurr[] = new boolean[sum/2 + 1];
            for(int j=0;j<=sum/2;j++){
                if(j<nums[i]){
                    dpCurr[j] = dpPrev[j];
                }else{
                    dpCurr[j] = dpPrev[j-nums[i]] || dpPrev[j];
                }
            }
            if(dpCurr[sum/2]){
                return true;
            }
            dpPrev = dpCurr;
        }
        return false;
    }
}