class Solution {
    Boolean dp[][][];
    char[][] grid;
    int n, m;
    public boolean hasValidPath(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        // can't start with ')'
        // can't end with '('
        // can't have odd length since length of path from 0,0 to n-1,m-1 will be n+m-1
        //since n+m is even so n+m-1 becomes odd and valid string can't be of odd length;
        if(grid[0][0]==')' || grid[n-1][m-1]=='(' || (n+m)%2==0){
            return false;
        }
        dp = new Boolean[n][m][101];
        this.grid = grid;
        return hasValidPathUtil(0,0,0,0);
    }
    
    private boolean hasValidPathUtil(int i, int j, int open, int close){
        if(grid[i][j]=='('){
            open++;
        }else{
            close++;
        }
        //if open less then close answer is not possible from this path
        if(open<close){
            return false;
        }
        // if reached last cell return true
        if(i==n-1 && j==m-1){
            if(open-close==0){
                return true;
            }else{
                return false;
            }
        }
        //in n+m-1 length open will be half and other half will be close
        //so open or close passes the half limit return false
        if(open>(n+m-1)/2 || close>(n+m-1)/2){
            return false;
        }
        //if already computed return value
        if(dp[i][j][open-close]!=null){
            return dp[i][j][open-close];
        }
        
        //make calls to right and down
        if(i==n-1){
            dp[i][j][open-close] = hasValidPathUtil(i, j+1, open, close);
        }else if(j==m-1){
            dp[i][j][open-close] = hasValidPathUtil(i+1, j, open, close);
        }else{
            dp[i][j][open-close] = hasValidPathUtil(i, j+1, open, close) || hasValidPathUtil(i+1, j, open, close);
        }
        return dp[i][j][open-close];
    }
}