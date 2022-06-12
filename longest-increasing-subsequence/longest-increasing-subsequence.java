class Solution {
    public int lengthOfLIS(int[] nums) {
        //return lengthOfLisN2(nums);
        return lengthOfLisNLogN(nums);
    }
    
    private int lengthOfLisNLogN(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        lis[0] = nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>lis[len-1]){
                lis[len] = nums[i];
                len++;
            }else{
                int idx = Arrays.binarySearch(lis, 0, len-1, nums[i]);
                if(idx<0){
                    idx = -(idx+1);
                }
                lis[idx] = nums[i];
            }
        }
        return len;
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