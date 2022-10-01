class Solution {
    public void rotate(int[][] matrix) {
        //1. Transpose the matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //2. Swap columns
        for(int i=0;i<matrix.length;i++){
            int st = 0, ed = matrix[i].length-1;
            while(st<ed){
                int temp = matrix[i][st];
                matrix[i][st] = matrix[i][ed];
                matrix[i][ed] = temp;
                st++;
                ed--;
            }
        }
    }
}