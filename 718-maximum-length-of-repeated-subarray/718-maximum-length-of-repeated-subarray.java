class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        if(n<m){
            return findLength(nums2, nums1);
        }
        
        int[] dp = new int[m+1];
        int ans = 0;
        
        for(int i=0;i<n;i++){
            int[] cur = new int[m+1];
            for(int j=0;j<m;j++){
                if(nums1[i] == nums2[j]){
                    cur[j+1] = dp[j] + 1;
                }else{
                    cur[j+1] = 0;
                }
                ans = Math.max(ans, cur[j+1]);
            }
            dp = cur;
        }
        
        return ans;
    }
}