class Solution {
    int[][] dir = new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    //dfs(i, j, grid);
                    bfs(i, j, grid);
                }
            }
        }
        return ans;
    }
    private void bfs(int row, int col, char[][] grid){
        Queue<Integer> que = new LinkedList<>();
        int nc = grid[0].length;
        que.add(row*nc + col);
        grid[row][col] = '0';
        while(!que.isEmpty()){
            int val = que.poll();
            int r = val/nc;
            int c = val%nc;
            for(int i=0;i<4;i++){
                int newRow = r + dir[i][0];
                int newCol = c + dir[i][1];
                if(isValid(newRow, newCol, grid)){
                    que.add(newRow*nc + newCol);
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
    private void dfs(int row, int col, char[][] grid){
        grid[row][col] = '0';
        for(int i=0;i<4;i++){
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if(isValid(newRow, newCol, grid)){
                dfs(newRow, newCol, grid);
            }
        }
    }
    private boolean isValid(int newRow, int newCol, char[][] grid){
        return newRow>=0 && newRow<grid.length && newCol>=0 
               && newCol<grid[0].length && grid[newRow][newCol]=='1';
    }
}