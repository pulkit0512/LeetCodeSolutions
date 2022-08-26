class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int cnt = 0;
        int sum = 0;
        for(int num:nums) {
            // prefix sum upto index i
            sum += num;
            
            // Increment the count to get number of subarrays with sum as (curSum-k)
            // This is done because, if for two indices i and j, sum[i]-sum[j] == k
            // then sum of elements between i and j equals to k.
            cnt += map.getOrDefault(sum-k, 0);
            
            // Increment frequency of current sum.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return cnt;
    }
}