class Solution {
    int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        int m = grid.length;
        int n = grid[0].length;
        pq.add(new int[]{0,0,0});
        grid[0][0] = 2;
        int minRemovals = 0;
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            if(cur[0]==m-1 && cur[1]==n-1){
                minRemovals = cur[2];
                break;
            }
            for(int i=0;i<4;i++){
                int newRow = dir[i][0] + cur[0];
                int newCol = dir[i][1] + cur[1];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n){
                    if(grid[newRow][newCol]==0){
                        pq.add(new int[]{newRow, newCol, cur[2]});
                    }else if(grid[newRow][newCol]==1){
                        pq.add(new int[]{newRow, newCol, cur[2]+1});
                    }
                    grid[newRow][newCol] = 2;
                }
            }
        }
        return minRemovals;
    }
}