class Solution {
    int ans;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int path[][] = new int[n][m];
        ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(path[i][j]==0){
                    DFS(matrix, path, i, j, n, m);
                }
            }
        }
        
        return ans;
    }
    private int DFS(int[][] mat, int path[][], int i, int j, int n, int m){
        if(path[i][j]!=0){
            return path[i][j];
        }
        int val = 0;
        if(i+1<n && mat[i][j]<mat[i+1][j]){
            int up = DFS(mat, path, i+1, j, n, m);
            val = Math.max(val, up);
        }
        if(i-1>=0 && mat[i][j]<mat[i-1][j]){
            int down = DFS(mat, path, i-1, j, n, m);
            val = Math.max(val, down);
        }
        if(j+1<m && mat[i][j]<mat[i][j+1]){
            int right = DFS(mat, path, i, j+1, n, m);
            val = Math.max(val, right);
        }
        if(j-1>=0 && mat[i][j]<mat[i][j-1]){
            int left = DFS(mat, path, i, j-1, n, m);
            val = Math.max(val, left);
        }
        path[i][j] = val+1;
        ans = Math.max(ans, path[i][j]);
        return path[i][j];
    }
}