class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!validate(board, i, j)){
                        return false;
                    }
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
        }
        int rowVal = 3*(row/3);
        int colVal = 3*(col/3);
        for(int i=rowVal;i<3+rowVal;i++){
            for(int j=colVal;j<3+colVal;j++){
                if(i==row && j==col){
                    continue;
                }
                if(board[i][j]==board[row][col]){
                    return false;
                }
            }
        }
        return true;
    }
}