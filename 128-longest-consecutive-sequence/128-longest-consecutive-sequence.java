class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                int cnt = 1;
                int val = nums[i]+1;
                while(set.contains(val)){
                    cnt++;
                    set.remove(val);
                    val++;
                }
                val = nums[i]-1;
                while(set.contains(val)){
                    cnt++;
                    set.remove(val);
                    val--;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}