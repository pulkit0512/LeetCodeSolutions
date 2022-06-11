class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int sq[][] = new int[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    if(i==0 || j==0){
                        sq[i][j] = 1;
                    }else{
                        sq[i][j] = Math.min(sq[i-1][j-1], Math.min(sq[i-1][j], sq[i][j-1])) + 1;
                    }
                    ans = Math.max(ans, sq[i][j]);
                }
            }
        }
        return ans*ans;
    }
}