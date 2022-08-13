class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                int cur = 1;
                int x = nums[i] - 1;
                while(true){
                    if(set.contains(x)){
                        set.remove(x);
                        cur++;
                        x--;
                    }else{
                        break;
                    }
                }
                x = nums[i]+1;
                while(true){
                    if(set.contains(x)){
                        set.remove(x);
                        cur++;
                        x++;
                    }else{
                        break;
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}