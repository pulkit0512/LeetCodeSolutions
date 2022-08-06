class Solution {
    public long countBadPairs(int[] nums) {
        //return countBadPairsNLogN(nums);
        return countBadPairsN(nums);
    }
    
    private long countBadPairsN(int[] nums) {
        long n = nums.length;
        long good = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = map.getOrDefault(i-nums[i], 0);
            good += val;
            map.put(i-nums[i], val+1);
        }
        
        return ((n*(n-1))/2) - good;
    }
    
    private long countBadPairsNLogN(int[] nums) {
        long ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int val = i-nums[i];
            if(!map.containsKey(val)){
                map.put(val, new ArrayList<>());
            }
            map.get(val).add(i);
        }
        for(int i=0;i<nums.length;i++){
            int val = i-nums[i];
            List<Integer> list = map.get(val);
            int idx = Collections.binarySearch(list, i);
            ans = ans + (nums.length - i) - (list.size() - idx);
        }
        return ans;
    }
}