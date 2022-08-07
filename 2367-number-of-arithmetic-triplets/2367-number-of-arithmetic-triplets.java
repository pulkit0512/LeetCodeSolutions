class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-diff) && set.contains(nums[i]-2*diff)){
                ans++;
            }
            set.add(nums[i]);
        }
        return ans;
    }
}