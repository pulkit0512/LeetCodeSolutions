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
        que.add(row*grid[0].length + col);
        grid[row][col] = '0';
        while(!que.isEmpty()){
            int val = que.poll();
            int r = val/grid[0].length;
            int c = val%grid[0].length;
            for(int i=0;i<4;i++){
                int newRow = r+dir[i][0];
                int newCol = c+dir[i][1];
                if(isValid(newRow, newCol, grid)){
                    que.add(newRow*grid[0].length + newCol);
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