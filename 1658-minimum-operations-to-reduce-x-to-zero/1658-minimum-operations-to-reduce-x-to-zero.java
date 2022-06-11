class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        Map<Integer, Integer> cSum = new HashMap<>();
        cSum.put(0, 0);
        int i;
        for(i=0;i<nums.length;i++){
            if(nums[i]>x){
                break;
            }
            sum += nums[i];
            cSum.put(sum, i+1);
        }
        sum = 0;
        int ans = Integer.MAX_VALUE;
        if(cSum.containsKey(x)){
            ans = cSum.get(x);
        }
        for(i=nums.length-1;i>=0;i--){
            if(nums[i]>x){
                break;
            }
            sum += nums[i];
            if(cSum.containsKey(x-sum) && cSum.get(x-sum)<i){
                ans = Math.min(ans, cSum.get(x-sum) + (nums.length-i));
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}