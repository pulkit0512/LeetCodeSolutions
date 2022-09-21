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
        
        for(int i=0;i<n;i++) {
            if(nums[queries[i][1]]%2==0){
                sum -= nums[queries[i][1]];
            }
            
            nums[queries[i][1]] += queries[i][0];
            
            if(nums[queries[i][1]]%2==0){
                sum += nums[queries[i][1]];
            }
            
            ans[i] = sum;
        }
        
        return ans;
    }
}