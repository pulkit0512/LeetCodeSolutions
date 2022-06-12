class Solution {
    int dp[][];
    int[] jobDifficulty;
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
        return minDifficultyUtil(0, 1, d);
    }
    
    private int minDifficultyUtil(int idx, int day, int d) {
        if(dp[idx][day]!=-1){
            return dp[idx][day];
        }
        if(day==d){
            int val = 0;
            for(int i=idx;i<len;i++){
                val = Math.max(val, jobDifficulty[i]);
            }
            return val;
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