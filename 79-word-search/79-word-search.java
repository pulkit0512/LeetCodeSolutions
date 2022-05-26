class Solution {
    int[][] dir = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    char temp = board[i][j];
                    board[i][j] = ' ';
                    if(wordSearchHelper(board, i, j, word, 1, len)){
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }
    private boolean wordSearchHelper(char[][] board, int i, int j, String word, int idx, int len) {
        if(idx==len){
            return true;
        }
        for(int[] d:dir){
            int newRow = d[0]+i;
            int newCol = d[1]+j;
            if(newRow>=0 && newCol>=0 && newRow<board.length && newCol<board[0].length 
               && board[newRow][newCol]==word.charAt(idx)){
                char temp = board[newRow][newCol];
                board[newRow][newCol] = ' ';
                if(wordSearchHelper(board, newRow, newCol, word, idx+1, len)){
                    return true;
                }
                board[newRow][newCol] = temp;
            }
        }
        return false;
    }
}