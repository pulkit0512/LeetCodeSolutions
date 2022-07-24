class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long ans = 0;
        for(int num:nums){
            if(num==0){
                count++;
            }else{
                ans = ans + (count*(count+1))/2;
                count = 0;
            }
        }
        ans = ans + (count*(count+1))/2;
        return ans;
    }
}