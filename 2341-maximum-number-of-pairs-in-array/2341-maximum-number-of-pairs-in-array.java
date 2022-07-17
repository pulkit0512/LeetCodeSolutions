class Solution {
    public int[] numberOfPairs(int[] nums) {
        int freq[] = new int[101];
        for(int num:nums){
            freq[num]++;
        }
        int[] ans = new int[2];
        for(int i=0;i<=100;i++){
            ans[0] += freq[i]/2;
            ans[1] += freq[i]%2;
        }
        return ans;
    }
}