class Solution {
    public int uniquePaths(int m, int n) {
        // Since swapping m and n doesn't make any difference we can swap it so that space becomes
        // min(m, n)
        if(m<n){
            int temp = m;
            m = n;
            n = temp;
        }
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n-1];
    }
}