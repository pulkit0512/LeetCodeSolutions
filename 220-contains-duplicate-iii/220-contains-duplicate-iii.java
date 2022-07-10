class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer successor = set.ceiling(nums[i]);
            if(successor!=null && successor<=(long)nums[i] + t){
                return true;
            }
            Integer predecessor = set.floor(nums[i]);
            if(predecessor!=null && predecessor>=(long)nums[i]-t){
                return true;
            }
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}