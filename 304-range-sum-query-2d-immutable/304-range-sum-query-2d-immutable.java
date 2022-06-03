class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j==0){
                    dp[i][j] = matrix[i][j];
                }else{
                    dp[i][j] = dp[i][j-1] + matrix[i][j];
                }
            }
        }
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                dp[i][j] += dp[i-1][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = dp[row2][col2];
        if(row1>=1 && col1>=1){
            ans += dp[row1-1][col1-1];
        }
        if(row1>=1){
            ans -= dp[row1-1][col2];
        }
        if(col1>=1){
            ans -= dp[row2][col1-1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */