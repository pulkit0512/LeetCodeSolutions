class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int INT_MAX = 1000000;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=0){
                    dp[i][j] = INT_MAX;
                }
            }
        }
        
        // top to bottom, left to right. This will take care of [i][j-1] and [i-1][j] neighbours.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=0){
                    if(i==0 && j==0){
                        continue;
                    }else if(i==0){
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                    }else if(j==0){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                    }else{
                        dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j], dp[i][j-1]) + 1);
                    }
                }
            }
        }
        
        // bottom to top, right to left. This will take care of [i][j+1] and [i+1][j] neighbours.
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(mat[i][j]!=0){
                    if(i==n-1 && j==m-1){
                        continue;
                    }else if(i==n-1){
                        dp[i][j] = Math.min(dp[i][j], dp[i][j+1]+1);
                    }else if(j==m-1){
                        dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
                    }else{
                        dp[i][j] = Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]) + 1);
                    }
                }
            }
        }
        return dp;
    }
}