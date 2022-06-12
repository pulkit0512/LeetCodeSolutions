class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthOfLisN2(nums);
    }
    
    private int lengthOfLisN2(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        lis[0] = 1;
        int oMax = 1;
        for(int i=1;i<n;i++){
            int max = 0;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    max = Math.max(max, lis[j]);
                }
                if(max==oMax){
                    break;
                }
            }
            lis[i] = max+1;
            oMax = Math.max(oMax, lis[i]);
        }
        return oMax;
    }
}