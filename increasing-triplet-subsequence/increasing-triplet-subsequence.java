class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return false;
        }
        int ans[] = new int[3];
        ans[0] = nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>ans[len-1]){
                ans[len] = nums[i];
                len++;
            }else{
                int idx = Arrays.binarySearch(ans, 0, len, nums[i]);
                if(idx<0){
                    idx = -(idx+1);
                }
                ans[idx] = nums[i];
            }
            if(len==3){
                return true;
            }
        }
        return false;
    }
}