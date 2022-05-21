class Solution {
    int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }
    private void dfs(int row, int col, char[][] grid){
        grid[row][col] = '0';
        for(int i=0;i<4;i++){
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if(newRow>=0 && newRow<grid.length && newCol>=0 
               && newCol<grid[0].length && grid[newRow][newCol]=='1'){
                dfs(newRow, newCol, grid);
            }
        }
    }
}