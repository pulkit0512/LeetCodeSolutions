class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> freqSum = new HashMap<>();
        int max = 0;
        for(int num:nums){
            max = Math.max(max, num);
            freqSum.put(num, freqSum.getOrDefault(num, 0) + num);
        }
        int prev2 = 0;
        int prev1 = freqSum.getOrDefault(1, 0);
        for(int i=2;i<=max;i++){
            int temp = prev1;
            prev1 = Math.max(prev2 + freqSum.getOrDefault(i, 0), prev1);
            prev2 = temp;
        }
        return prev1;
    }
}