class Solution {
    char[][] board;
    String word;
    int dir[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        this.board = board;
        this.word = word;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    char temp = board[i][j];
                    board[i][j] = '0';
                    if(wordSearchUtil(1, len, i, j)){
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }
    
    private boolean wordSearchUtil(int idx, int len, int row, int col) {
        if(idx==len){
            return true;
        }
        for(int i=0;i<4;i++){
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if(newRow>=0 && newCol>=0 && newRow<board.length && newCol<board[0].length 
               && board[newRow][newCol]==word.charAt(idx)){
                char temp = board[newRow][newCol];
                board[newRow][newCol] = '0';
                if(wordSearchUtil(idx+1, len, newRow, newCol)){
                    return true;
                }
                board[newRow][newCol] = temp;
            }
        }
        return false;
    }
}