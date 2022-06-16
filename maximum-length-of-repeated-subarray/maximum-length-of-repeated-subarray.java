class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n<m){
            return findLength(nums2, nums1);
        }
        int dpPrev[] = new int[m+1];
        int dpCurr[] = new int[m+1];
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dpCurr[j] = dpPrev[j-1]+1;
                }else{
                    dpCurr[j] = 0;
                }
            }
            for(int j=1;j<=m;j++){
                dpPrev[j] = dpCurr[j];
                ans = Math.max(ans, dpPrev[j]);
            }
        }
        return ans;
    }
}