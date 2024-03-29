class Solution {
    public int maximalSquare(char[][] matrix) {
        return maximalSquareNSpace(matrix);
        //return maximalSquareMNSpace(matrix);
    }
    
    private int maximalSquareNSpace(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int prev[] = new int[n];
        
        for(int i=0;i<m;i++){
            int[] cur = new int[n];
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') {
                    if(i==0||j==0){
                        cur[j] = 1;
                    }else{
                        int val = Math.min(prev[j-1], Math.min(prev[j], cur[j-1]));
                        cur[j] = val+1;
                    }
                    ans = Math.max(ans, cur[j]);
                }
            }
            prev = cur;
        }
        
        return ans*ans;
    }
    
    private int maximalSquareMNSpace(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int dp[][] = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1') {
                    if(i==0||j==0){
                        dp[i][j] = 1;
                    }else{
                        int val = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                        dp[i][j] = val+1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        
        return ans*ans;
    }
}