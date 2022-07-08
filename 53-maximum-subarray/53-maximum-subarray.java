class Solution {
    public int maxSubArray(int[] nums) {
        //return divideAndConquerMax(nums, 0, nums.length-1);
        
        return kadaneMax(nums);
    }
    
    private int kadaneMax(int[] nums) {
        //O(N) time Complexity
        int maxSoFar = Integer.MIN_VALUE, maxEndHere = 0;
        for(int num:nums){
            maxEndHere = Math.max(maxEndHere+num, num);
            maxSoFar = Math.max(maxSoFar, maxEndHere);
        }
        return maxSoFar;
    }
    
    private int divideAndConquerMax(int nums[], int st, int ed){
        if(st == ed){
            return nums[st];
        }
        int mid = (st+ed)/2;
        
        int leftMaxSum = divideAndConquerMax(nums, st, mid);
        int rightMaxSum = divideAndConquerMax(nums, mid+1, ed);
        int sumCrossingMid = helper(nums, st, mid, ed);
        
        return Math.max(Math.max(leftMaxSum, rightMaxSum), sumCrossingMid);
    }
    
    private int helper(int nums[], int l, int m, int h) {
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=m;i>=l;i--){
            sum += nums[i];
            if(sum>leftSum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int i=m+1;i<=h;i++){
            sum += nums[i];
            if(sum>rightSum){
                rightSum = sum;
            }
        }
        return Math.max(leftSum + rightSum, Math.max(leftSum, rightSum));
    }
    
    
}