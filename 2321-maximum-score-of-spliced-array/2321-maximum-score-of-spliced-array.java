class Solution {
    // maxSum(B) = sum(B) + kadane(A - B)
    // maxSum(A) = sum(A) + kadane(B - A)
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(kadane(nums1, nums2), kadane(nums2, nums1));
    }
    
    private int kadane(int[] nums1, int[] nums2){
        int maxSoFar = 0, maxEndHere = 0;
        int sum2 = 0;
        for(int i=0;i<nums1.length;i++){
            sum2 += nums2[i];
            maxEndHere = Math.max(maxEndHere + nums1[i]-nums2[i], nums1[i]-nums2[i]);
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar+sum2;
    }
}