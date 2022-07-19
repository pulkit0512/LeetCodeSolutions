class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for(int num:nums){
            // Compute prefix sum upto index i.
            sum += num;
            // Add count of subarrays already in map with sum = curSum - k.
            // This is done because, if for two indices i and j, sum[i]-sum[j] == k
            // then sum of elements between i and j equals to k.
            count += map.getOrDefault(sum-k, 0);
            // increment frequency of curSum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}