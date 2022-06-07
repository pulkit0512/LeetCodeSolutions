class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==1){
                ans++;
            }
        }
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==1){
                ans++;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    matrix[i][j] = Math.min(matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]))+1;
                    ans += matrix[i][j];
                }
            }
        }
        return ans;
    }
}