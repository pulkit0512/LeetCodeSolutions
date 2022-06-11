class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> freqSum = new HashMap<>();
        int max = 0;
        for(int num:nums){
            max = Math.max(max, num);
            freqSum.put(num, freqSum.getOrDefault(num, 0) + num);
        }
        int points[] = new int[max+1];
        points[1] = freqSum.getOrDefault(1, 0);
        for(int i=2;i<=max;i++){
            points[i] = Math.max(points[i-2] + freqSum.getOrDefault(i, 0), points[i-1]);
        }
        return points[max];
    }
}