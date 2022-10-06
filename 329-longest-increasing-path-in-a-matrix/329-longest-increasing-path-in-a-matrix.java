class Solution {
    int ans;
    public int longestIncreasingPath(int[][] matrix) {
        ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] path = new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(matrix, path, i, j);
            }
        }
        
        return ans;
    }
    
    private int dfs(int[][] matrix, int[][] path, int i, int j) {
        if(path[i][j]!=0){
            return path[i][j];
        }
        
        int val = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(i+1<m && matrix[i+1][j]>matrix[i][j]){
            int down = 1 + dfs(matrix, path, i+1, j);
            val = Math.max(val, down);
        }
        
        if(j+1<n && matrix[i][j+1]>matrix[i][j]){
            int right = 1 + dfs(matrix, path, i, j+1);
            val = Math.max(val, right);
        }
        
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]){
            int up = 1 + dfs(matrix, path, i-1, j);
            val = Math.max(val, up);
        }
        
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]){
            int left = 1 + dfs(matrix, path, i, j-1);
            val = Math.max(val, left);
        }
        
        path[i][j] = val;
        ans = Math.max(ans, val);
        return path[i][j];
    }
}