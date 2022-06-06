class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int limit = (1<<n);
        List<List<Integer>> sets = new ArrayList<>();
        for(int i=0;i<limit;i++){
            sets.add(getSubset(nums, i));
        }
        return sets;
    }
    private List<Integer> getSubset(int[] nums, int i) {
        List<Integer> set = new ArrayList<>();
        int idx = 0;
        while(i>0){
            if((i&1)==1){
                set.add(nums[idx]);
            }
            i = i>>1;
            idx++;
        }
        return set;
    }
}