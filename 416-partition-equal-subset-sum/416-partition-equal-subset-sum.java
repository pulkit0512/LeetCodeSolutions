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
                    if(dpPrev[j]){
                        dpCurr[j] = true;
                    }
                }else if(dpPrev[j-nums[i]] || dpPrev[j]){
                    dpCurr[j] = true;
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