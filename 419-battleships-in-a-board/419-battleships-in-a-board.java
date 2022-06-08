class Solution {
    public int countBattleships(char[][] board) {
        int ships = 0;
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X'){
                    ships++;
                    if(i-1>=0 && board[i-1][j]=='X'){
                        ships--;
                    }else if(j-1>=0 && board[i][j-1]=='X'){
                        ships--;
                    }
                }
            }
        }
        return ships;
    }
}