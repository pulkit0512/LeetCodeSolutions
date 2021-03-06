class Solution {
    public void setZeroes(int[][] matrix) {
        //setZeroesUsingMPlusNSpace(matrix);
        setZeroesUsingConstantSpace(matrix);
    }
    
    private void setZeroesUsingConstantSpace(int[][] matrix) {
        boolean isCol = false;
        int n = matrix.length, m = matrix[0].length;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                isCol = true;
            }
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j] = 0;
            }
        }
        if(isCol){
            for(int i=0;i<n;i++){
                matrix[i][0] = 0;
            }
        }
    }
    
    private void setZeroesUsingMPlusNSpace(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}