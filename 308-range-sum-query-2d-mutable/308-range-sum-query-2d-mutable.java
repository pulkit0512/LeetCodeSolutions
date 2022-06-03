class NumMatrix {

    int[][] mat;
    public NumMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        this.mat = matrix;
    }
    
    public void update(int row, int col, int val) {
        int prev = (col==0)?this.mat[row][col]:(this.mat[row][col]-this.mat[row][col-1]);
        int inc = val - prev;
        for(int i=col;i<this.mat[0].length;i++){
            this.mat[row][i] += inc;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                ans += this.mat[i][col2];
            }else{
                ans += (this.mat[i][col2]-this.mat[i][col1-1]);
            }
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */