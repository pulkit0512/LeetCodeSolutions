class Solution {
    public boolean isValidSudoku(char[][] board) {
        //return isValidSudokuN3(board);
        return isValidSudokuN2(board);
    }
    
    private boolean isValidSudokuN2(char[][] board) {
        int rows[][] = new int[9][9];
        int cols[][] = new int[9][9];
        int squares[][] = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                
                int arrPos = board[i][j]-'1';
                if(rows[i][arrPos]==1){
                    return false;
                }
                rows[i][arrPos] = 1;
                
                if(cols[arrPos][j]==1){
                    return false;
                }
                cols[arrPos][j]=1;
                
                int idx = 3*(i/3) + j/3;
                if(squares[idx][arrPos]==1){
                    return false;
                }
                squares[idx][arrPos] = 1;
            }
        }
        return true;
    }
    
    // TC: O(N^3) and SC: O(1)
    private boolean isValidSudokuN3(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !validate(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean validate(char[][] board, int row, int col) {
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==board[row][col]){
                return false;
            }
            
            if(i!=col && board[row][i]==board[row][col]){
                return false;
            }
            
            int rowSmallSquare = 3*(row/3) + i/3;
            int colSmallSquare = 3*(col/3) + i%3;
            if(board[rowSmallSquare][colSmallSquare]==board[row][col] 
               && row!=rowSmallSquare && col!=colSmallSquare){
                return false;
            }
        }
        
        /*int rowVal = 3*(row/3);
        int colVal = 3*(col/3);
        for(int i=rowVal;i<3+rowVal;i++){
            for(int j=colVal;j<3+colVal;j++){
                if(i!=row && j!=col && board[i][j]==board[row][col]){
                    return false;
                }
            }
        }*/
        
        return true;
    }
}