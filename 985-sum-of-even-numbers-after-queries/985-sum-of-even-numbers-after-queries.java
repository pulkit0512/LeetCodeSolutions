class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        
        int sum = 0;
        for(int num:nums) {
            if(num%2==0){
                sum += num;
            }
        }
        
        int idx = 0;
        for(int[] query:queries) {
            if(nums[query[1]]%2==0){
                sum -= nums[query[1]];
            }
            
            nums[query[1]] += query[0];
            
            if(nums[query[1]]%2==0){
                sum += nums[query[1]];
            }
            
            ans[idx++] = sum;
        }
        
        return ans;
    }
}