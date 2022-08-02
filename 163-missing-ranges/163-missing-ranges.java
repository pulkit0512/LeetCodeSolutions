class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if(nums.length==0){
            helper(lower, upper, ans);
            return ans;
        }
        int st = lower;
        int ed = nums[0]-1;
        helper(st, ed, ans);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                continue;
            }
            st = nums[i]+1;
            ed = nums[i+1]-1;
            helper(st, ed, ans);
        }
        st = nums[nums.length-1]+1;
        ed = upper;
        helper(st, ed, ans);
        return ans;
    }
    private void helper(int st, int ed, List<String> ans){
        if(st==ed){
            ans.add(String.valueOf(st));
        }else if(st<ed){
            ans.add(st+"->"+ed);
        }
    }
}