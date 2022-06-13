class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSub = maxKadane(nums);
        int minSub = minKadane(nums);
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum==minSub){
            return maxSub;
        }
        return Math.max(maxSub, sum-minSub);
    }
    
    private int maxKadane(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, maxEndHere = 0;
        for(int num:nums){
            maxEndHere = Math.max(maxEndHere + num, num);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
    
    private int minKadane(int[] nums) {
        int minSoFar = Integer.MAX_VALUE, minEndHere = 0;
        for(int num:nums) {
            minEndHere = Math.min(minEndHere + num, num);
            minSoFar = Math.min(minSoFar, minEndHere);
        }
        return minSoFar;
    }
}