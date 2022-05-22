class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            if(!map.containsKey(sum)){
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum)+1);
        }
        return ans;
    }
}