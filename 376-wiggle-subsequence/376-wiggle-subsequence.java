class Solution {
    public int wiggleMaxLength(int[] nums) {
        //return wiggleMaxLengthN(nums);
        return wiggleMaxLengthN2(nums);
    }
    
    private int wiggleMaxLengthN(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return n;
        }
        int inc = 1, dec = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                inc = dec + 1;
            }else if(nums[i]<nums[i-1]){
                dec = inc + 1;
            }
        }
        return Math.max(inc, dec);
    }
    
    private int wiggleMaxLengthN2(int[] nums) {
        int n = nums.length;
        if(n<=1){
            return n;
        }
        int dpG[] = new int[n];
        int dpS[] = new int[n];
        dpS[0] = 1;
        dpG[0] = 1;
        int omax = 1;
        for(int i=1;i<n;i++){
            int maxS = 0, maxG = 0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxG = Math.max(maxG, dpS[j]+1);
                }else if(nums[i]<nums[j]){
                    maxS = Math.max(maxS, dpG[j]+1);
                }
            }
            dpG[i] = maxG;
            dpS[i] = maxS;
            omax = Math.max(omax, Math.max(dpG[i], dpS[i]));
        }
        return omax;
    }
}