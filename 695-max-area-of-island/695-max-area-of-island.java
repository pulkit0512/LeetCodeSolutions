class Solution {
    int dir[][] = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area = bfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    
    private int bfs(int[][] grid, int row, int col) {
        Queue<Integer> que = new LinkedList<>();
        int nCol = grid[0].length;
        int nRow = grid.length;
        que.add(row*nCol + col);
        grid[row][col] = 0;
        int area = 0;
        while(!que.isEmpty()){
            int rowCol = que.poll();
            area++;
            int r = rowCol/nCol;
            int c = rowCol%nCol;
            for(int i=0;i<4;i++){
                int newRow = r + dir[i][0];
                int newCol = c + dir[i][1];
                if(newRow>=0 && newRow<nRow && newCol>=0 && newCol<nCol && grid[newRow][newCol]==1){
                    grid[newRow][newCol] = 0;
                    que.add(newRow*nCol + newCol);
                }
            }
        }
        return area;
    }
}