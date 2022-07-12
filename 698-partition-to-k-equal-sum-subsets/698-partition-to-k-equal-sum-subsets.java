class Solution {
    int possibleSum;
    int k;
    Map<Integer, Boolean> memo;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        int n = nums.length;
        for(int num:nums){
            total += num;
        }
        if(total%k!=0){
            return false;
        }
        Arrays.sort(nums);
        for(int i=0;i<n/2;i++){
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
        possibleSum = total/k;
        this.k = k;
        memo = new HashMap<>();
        return backtrack(nums, 0, 0, 0, 0);
    }
    
    private boolean backtrack(int[] nums, int idx, int count, int curSum, int mask){
        if(count==k-1){
            return true;
        }
        if(curSum>possibleSum){
            return false;
        }
        if(memo.containsKey(mask)){
            return memo.get(mask);
        }
        if(curSum == possibleSum){
            boolean isPossible = backtrack(nums, 0, count+1, 0, mask);
            memo.put(mask, isPossible);
            return isPossible;
        }
        for(int i=idx;i<nums.length;i++){
            if(((mask>>i)&1)==0){
                mask = mask | (1<<i);
                boolean isPossible = backtrack(nums, i+1, count, curSum + nums[i], mask);
                if(isPossible){
                    memo.put(mask, true);
                    return true;
                }
                mask = mask ^ (1<<i);
            }
        }
        memo.put(mask, false);
        return false;
    }
}