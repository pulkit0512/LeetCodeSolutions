class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int totalSubsets = (1<<n);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<totalSubsets;i++){
            List<Integer> subset = new ArrayList<>();
            for(int j=0;j<10;j++){
                if(((i>>j)&1)!=0){
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}