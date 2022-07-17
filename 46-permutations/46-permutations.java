class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans);
        return ans;
    }
    
    private void backtrack(int[] nums, int st, List<List<Integer>> ans){
        if(st==nums.length-1){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(list);
            return;
        }
        for(int i=st;i<nums.length;i++){
            swap(nums, st, i);
            backtrack(nums, st+1, ans);
            swap(nums, st, i);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}