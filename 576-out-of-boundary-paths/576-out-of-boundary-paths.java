class Solution {
    int mod = 1000000007;
    Integer dp[][][];
    int dir[][] = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove+1];
        dp[startRow][startColumn][0] = 0;
        findPathsUtil(m, n, maxMove, startRow, startColumn);
        return dp[startRow][startColumn][maxMove];
    }
    
    private int findPathsUtil(int m, int n, int maxMove, int row, int col){
        if(row>=m || col>=n || row<0 || col<0){
            return 1;
        }
        if(maxMove==0){
            return 0;
        }
        //System.out.println(row + " " + col + " " + maxMove);
        if(dp[row][col][maxMove]!=null){
            return dp[row][col][maxMove];
        }
        int paths = 0;
        for(int i=0;i<4;i++){
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            paths = (paths + findPathsUtil(m, n, maxMove-1, newRow, newCol))%mod;
        }
        return dp[row][col][maxMove] = paths;
    }
}