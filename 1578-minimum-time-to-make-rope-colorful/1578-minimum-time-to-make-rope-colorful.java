class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int max = neededTime[0];
        int sum = neededTime[0];
        for(int i=1;i<neededTime.length;i++){
            if(colors.charAt(i-1)==colors.charAt(i)){
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
            }else{
                // Greedy way we will burst balloons with less time and will keep maximum time balloon
                ans = ans + (sum - max); // Total time of a group of same color - max time of a balloon
                
                max = neededTime[i];
                sum = neededTime[i];
            }
        }
        
        // For last group
        return ans + (sum-max);
    }
}