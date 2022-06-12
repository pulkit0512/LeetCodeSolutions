class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if(len<d){
            return -1;
        }
        int dp[][] = new int[len][d+1];
        // Set base cases
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // On the last day, we must schedule all remaining jobs, so dp[i][d]
        // is the maximum difficulty job remaining
        dp[len-1][d] = jobDifficulty[len-1];
        for(int i=len-2;i>=0;i--){
            dp[i][d] = Math.max(dp[i+1][d], jobDifficulty[i]);
        }
        for(int day=d-1;day>0;day--){
            for(int i=day-1;i<len-(d-day);i++){
                int hard = 0;
                // Iterate through the options and choose the best
                for(int j=i;j<len-(d-day);j++){
                    hard = Math.max(hard, jobDifficulty[j]);
                    dp[i][day] = Math.min(dp[i][day], hard + dp[j+1][day+1]);
                }
            }
        }
        return dp[0][1];
    }
    
    //Using DP as Memoization
    /*int dp[][];
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
    }*/
}