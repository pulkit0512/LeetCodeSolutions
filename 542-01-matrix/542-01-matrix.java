class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], 1000000);
        }
        if(mat[0][0] == 0){
            dp[0][0] = 0;
        }
        for(int i=1;i<m;i++){
            if(mat[0][i]!=0){
                dp[0][i] = Math.min(dp[0][i], dp[0][i-1] + 1);
            }else{
                dp[0][i] = 0;
            }
        }
        for(int i=1;i<n;i++){
            if(mat[i][0]!=0){
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0] + 1);
            }else{
                dp[i][0] = 0;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]!=0){
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j], dp[i][j-1]) + 1);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=m-2;i>=0;i--){
            if(mat[n-1][i]!=0){
                dp[n-1][i] = Math.min(dp[n-1][i], dp[n-1][i+1] + 1);
            }
        }
        for(int i=n-2;i>=0;i--){
            if(mat[i][m-1]!=0){
                dp[i][m-1] = Math.min(dp[i][m-1], dp[i+1][m-1] + 1);
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(mat[i][j]!=0){
                    dp[i][j] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]) + 1);
                }
            }
        }
        return dp;
    }
}