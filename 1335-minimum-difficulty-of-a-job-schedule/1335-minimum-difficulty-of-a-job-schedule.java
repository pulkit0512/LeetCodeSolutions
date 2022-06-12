class Solution {
    int dp[][];
    int[] jobDifficulty;
    int[] hardest;
    int len;
    public int minDifficulty(int[] jobDifficulty, int d) {
        dp = new int[300][11];
        for(int i=0;i<300;i++){
            Arrays.fill(dp[i], -1);
        }
        this.jobDifficulty = jobDifficulty;
        this.len = jobDifficulty.length;
        if(d>this.len){
            return -1;
        }
        this.hardest = new int[len];
        hardest[len-1] = jobDifficulty[len-1];
        for(int i=len-2;i>=0;i--){
            hardest[i] = Math.max(hardest[i+1], jobDifficulty[i]);
        }
        return minDifficultyUtil(0, 1, d);
    }
    
    private int minDifficultyUtil(int idx, int day, int d) {
        if(dp[idx][day]!=-1){
            return dp[idx][day];
        }
        if(day==d){
            return hardest[idx];
        }
        int val = Integer.MAX_VALUE, curr = 0;
        for(int i=idx;i<len-(d-day);i++){
            curr = Math.max(curr, jobDifficulty[i]);
            val = Math.min(val, curr + minDifficultyUtil(i+1, day+1, d));
        }
        dp[idx][day] = val;
        return val;
    }
}