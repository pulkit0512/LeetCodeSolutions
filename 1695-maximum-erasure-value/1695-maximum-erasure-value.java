class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int st = 0;
        int score = 0, maxScore = 0;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                score += nums[i];
            }else{
                maxScore = Math.max(maxScore, score);
                while(nums[st]!=nums[i]){
                    score -= nums[st];
                    set.remove(nums[st]);
                    st++;
                }
                st++;
            }
        }
        maxScore = Math.max(maxScore, score);
        return maxScore;
    }
}