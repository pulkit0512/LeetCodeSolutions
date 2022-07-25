class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int idx = Arrays.binarySearch(nums, target);
        if(idx<0){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        ans[0] = idx;
        ans[1] = idx;
        
        while(true) {
            idx = Arrays.binarySearch(nums, 0, idx, target);
            if(idx<0){
                break;
            }else{
                ans[0] = idx;
            }
        }
        
        idx = ans[1];
        while(true) {
            idx = Arrays.binarySearch(nums, idx+1, nums.length, target);
            if(idx<0){
                break;
            }else{
                ans[1] = idx;
            }
        }
        
        return ans;
    }
}